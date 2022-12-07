package com.puccode.snacksserver.services;

import io.grpc.stub.StreamObserver;
import stubs.APIResponse;
import stubs.Order;
import stubs.OrderID;
import stubs.clientGrpc;

import java.util.LinkedList;
import java.util.Queue;

public class ClientServices extends clientGrpc.clientImplBase {

    private Queue<Order> pedidos = new LinkedList<>();


    @Override
    public void registerOrder(Order request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("register order called");

        if (request != null) {
            pedidos.add(request);
        }

        APIResponse.Builder response = APIResponse.newBuilder();
        response.setMessageCode(0).setResponseMessage("SUCESS");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void cancelOrder(OrderID request, StreamObserver<APIResponse> responseObserver) {

    }
}
