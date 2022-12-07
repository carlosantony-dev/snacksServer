package com.puccode.snacksserver;

import com.puccode.snacksserver.forms.Home;
import com.puccode.snacksserver.services.ClientServices;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main implements Runnable {
    public static void main(String[] args) throws IOException, InterruptedException {
        SwingUtilities.invokeLater(new Main());

        //André, forPort method, is very similar of Socket class: Socket socker = new Socket(address, port);
        Server server = ServerBuilder.forPort(9090).addService(new ClientServices()).build();
        server.start();
        System.out.println("Server started at: " + server.getPort());

        server.awaitTermination();
    }

    @Override
    public void run() {
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(new Home().getHomePainel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Java Snacks Restaurant");
        jFrame.setSize(new Dimension(1080, 720));
        jFrame.setVisible(true);
    }
}