package com.puccode.snacksserver.services;

import com.puccode.snacksserver.forms.Home;
import io.grpc.stub.StreamObserver;
import stubs.APIResponse;
import stubs.Order;
import stubs.OrderID;
import stubs.clientGrpc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class Services extends clientGrpc.clientImplBase {

    private Queue<Order> pedidos = new LinkedList<>();

    private String url = "jdbc:postgresql://babar.db.elephantsql.com:5432/dkwbukmc";
    private String user = "dkwbukmc";
    private String password = "eM-EGnPu4CSqqaHRTccI7YeW60pISDBx";

    private static final String INSERT_PEDIDO_SQL = "INSERT INTO pedidos" +
            "  (pedido, mesa, observacoes, qtd_pedido, data_pedido, hora_pedido) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    private static final String DELETE_PEDIDO_SQL = "DELETE FROM pedidos WHERE id = " + "(?);";
    Connection connection = null;
    private final Home myHome;

    public Services(Home home) {
        myHome = home;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão realizada com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public int insertRecord(Order order) throws SQLException {
        int res = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEDIDO_SQL);
            preparedStatement.setString(1, order.getName());
            preparedStatement.setInt(2, (int) order.getCustomerTable());
            preparedStatement.setString(3, order.getObservations());
            preparedStatement.setInt(4, (int) order.getQuantidade());
            preparedStatement.setString(5,"HORA TESTE");
            preparedStatement.setString(6, "HORA TESTE");

            res = preparedStatement.executeUpdate();

        } catch(SQLException e) {
            printSQLException(e);
        }
        return res;
    }

    public int deleteRecord(Integer pedido_id) throws SQLException {
        int res = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PEDIDO_SQL);
            preparedStatement.setInt(1, pedido_id);

            res = preparedStatement.executeUpdate();

            System.out.println(preparedStatement);

        } catch(SQLException e) {
            printSQLException(e);
        }
        return res;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public void registerOrder(Order request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("register order called");
        int result = 0;

        if (request != null) {
            pedidos.add(request);
        }
        
        myHome.refreshOrders(pedidos);
        APIResponse.Builder response = APIResponse.newBuilder();

        try {
            result = insertRecord(request);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result == 1) {
            response.setMessageCode(200).setResponseMessage("Pedido solicitado com sucesso!");
        } else {
            response.setMessageCode(404).setResponseMessage("Pedido registrado! Algo de errado no banco aconteceu...");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void cancelOrder(OrderID request, StreamObserver<APIResponse> responseObserver) {
        int result = 0;
        APIResponse.Builder response = APIResponse.newBuilder();

        try {
            if (request != null) {
                if (!pedidos.isEmpty()) {
                    int pos = 0;
                    for (Order ord : pedidos) {
                        if (pos == request.getOrderNumber()) {
                            pedidos.remove(ord);
                        }
                        pos++;
                    }

                    result = deleteRecord(request.getOrderNumber()+1);

                    if (result == 1) {
                        response.setMessageCode(200).setResponseMessage("Pedido cancelado com sucesso!");
                    } else {
                        response.setMessageCode(404).setResponseMessage("Pedido Cancelado! Algo de errado no banco aconteceu...");
                    }
                } else {
                    response.setMessageCode(404).setResponseMessage("A lista de pedidos está vázia! Não há o que cancelar.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        myHome.refreshOrders(pedidos);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
