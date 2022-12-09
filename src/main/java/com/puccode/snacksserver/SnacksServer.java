package com.puccode.snacksserver;

import com.puccode.snacksserver.forms.Home;
import com.puccode.snacksserver.services.Services;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class SnacksServer implements Runnable {

    private static Home myHome;

    private static Connection connection = null;

    private static String url = "jdbc:postgresql://babar.db.elephantsql.com:5432/dkwbukmc";
    private static String user = "dkwbukmc";
    private static String password = "eM-EGnPu4CSqqaHRTccI7YeW60pISDBx";

    private static final String CREATE_TABLE_PEDIDOS = "CREATE TABLE public.pedidos (id serial NOT NULL, " +
            "pedido character varying(255) NOT NULL, mesa integer NOT NULL, observacoes character varying(255) NULL, " +
            "qtd_pedido integer NOT NULL, data_pedido character varying(255) NOT NULL, " +
            "hora_pedido character varying(255) NOT NULL);";

    private static final String DROP_TABLE_PEDIDOS = "DROP TABLE IF EXISTS pedidos";

    public static void main(String[] args) throws IOException, InterruptedException {
        myHome = new Home();
        SwingUtilities.invokeLater(new SnacksServer());

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_PEDIDOS);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //André, forPort method, is very similar of Socket class: Socket socker = new Socket(address, port);
        Server server = ServerBuilder.forPort(9090).addService(new Services(myHome)).build();
        server.start();
        System.out.println("Server started at: " + server.getPort());

        server.awaitTermination();
    }

    @Override
    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(myHome.getContentPane());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Java Snacks Restaurant");
        jFrame.setSize(new Dimension(1080, 720));
        jFrame.setVisible(true);

        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                PreparedStatement preparedStatement = null;
                try {
                    preparedStatement = connection.prepareStatement(DROP_TABLE_PEDIDOS);
                    preparedStatement.executeUpdate();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
