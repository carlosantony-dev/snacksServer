package com.puccode.snacksserver.forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import javax.swing.*;

import stubs.Order;

/**
 *
 * @author carlo
 */
public class Home extends javax.swing.JFrame {
    
    private Map<Integer, Order> ordersRequested;
    private int key;
    
    public Home() {
        key = 0;
        ordersRequested = new HashMap<Integer, Order>();
        initComponents();
        main_window.setLayout(new GridLayout(5,3, 10, 10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        main_window = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Pedidos realizados");

        main_window.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout main_windowLayout = new javax.swing.GroupLayout(main_window);
        main_window.setLayout(main_windowLayout);
        main_windowLayout.setHorizontalGroup(
            main_windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        main_windowLayout.setVerticalGroup(
            main_windowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(main_window, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(30, 30, 30)
                .addComponent(main_window, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });

    }
    
    public void refreshOrders(Queue<Order> orders) {
        main_window.removeAll();
        int priority = 1;
        for (Order ord : orders) {
            JPanel newJpanel = new JPanel();
            newJpanel.setSize(new Dimension(150,150));
            newJpanel.setBackground(Color.cyan);
            newJpanel.add(new JLabel("Posição: " + priority + " Pedido: " + ord.getName()));
            newJpanel.add(new JLabel("Mesa: " + ord.getCustomerTable()));
            newJpanel.add(new JLabel("Qtd: " + ord.getQuantidade()));
            newJpanel.add(new JLabel("Obs: " + ord.getObservations()));
            main_window.add(newJpanel);
            priority++;
        }
        main_window.revalidate();
        main_window.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel main_window;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
