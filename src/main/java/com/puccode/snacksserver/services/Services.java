package com.puccode.snacksserver.services;

import com.puccode.snacksserver.forms.Home;
import io.grpc.stub.StreamObserver;
import stubs.APIResponse;
import stubs.Order;
import stubs.OrderID;
import stubs.clientGrpc;

import java.util.LinkedList;
import java.util.Queue;

public class Services extends clientGrpc.clientImplBase {

    private Queue<Order> pedidos = new LinkedList<>();
    private final Home myHome;

    public Services(Home home) {
        myHome = home;
    }


    @Override
    public void registerOrder(Order request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("register order called");

        if (request != null) {
            pedidos.add(request);
        }
        
        myHome.refreshOrders(pedidos);
        APIResponse.Builder response = APIResponse.newBuilder();
        response.setMessageCode(200).setResponseMessage("Pedido solicitado com sucesso!");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void cancelOrder(OrderID request, StreamObserver<APIResponse> responseObserver) {
        APIResponse.Builder response = APIResponse.newBuilder();

        if (request != null) {
            if (!pedidos.isEmpty()) {
                int pos = 0;
                for (Order ord : pedidos) {
                    if (pos == request.getOrderNumber()) {
                        pedidos.remove(ord);
                    }
                    pos++;
                }
                response.setMessageCode(200).setResponseMessage("Pedido cancelado com sucesso!");
            } else {
                response.setMessageCode(404).setResponseMessage("A lista de pedidos está vázia! Não há o que cancelar.");
            }
        }
        myHome.refreshOrders(pedidos);

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
