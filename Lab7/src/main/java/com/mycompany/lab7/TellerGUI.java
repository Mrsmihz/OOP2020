/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab7;

/**
 *
 * @author FAITH
 */
import javax.swing.*;
import java.awt.*;
public class TellerGUI {
    private JFrame myFrame;
    private JPanel mainPanel, topPanel, bottomPanel;
    private JLabel balanceLabel, amountLabel;
    private JButton btnDeposit, btnWithdraw, btnExit;
    private JTextField balanceField, amountField;
    private Font myFont;
    public TellerGUI(){
        myFrame = new JFrame("TellerGUI");
        //myFrame.setSize(400, 400);
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        myFrame.add(mainPanel);
        
        myFont = new Font("SansSerif", Font.BOLD, 20);
        
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2));
        balanceLabel = new JLabel(" Balance", JLabel.CENTER);
        amountLabel = new JLabel(" Amount", JLabel.CENTER);
        balanceField = new JTextField("6000");
        amountField = new JTextField();
        balanceField.setHorizontalAlignment(JTextField.RIGHT);
        amountField.setHorizontalAlignment(JTextField.RIGHT);
        balanceLabel.setFont(myFont);
        amountLabel.setFont(myFont);
        balanceField.setFont(myFont);
        amountField.setFont(myFont);
        balanceField.setPreferredSize(new Dimension(200, 40));
        balanceField.setEditable(false);
        topPanel.add(balanceLabel);
        topPanel.add(balanceField);
        topPanel.add(amountLabel);
        topPanel.add(amountField);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(200, 80));
        bottomPanel.setLayout(new FlowLayout());
        btnDeposit = new JButton("Deposit");
        btnWithdraw = new JButton("Withdraw");
        btnExit = new JButton("Exit");
        btnDeposit.setPreferredSize(new Dimension(100, 30));
        btnWithdraw.setPreferredSize(new Dimension(100, 30));
        btnExit.setPreferredSize(new Dimension(100, 30));
        bottomPanel.add(btnDeposit);
        bottomPanel.add(btnWithdraw);
        bottomPanel.add(btnExit);
        mainPanel.add(bottomPanel);
        
        myFrame.setResizable(false);
        myFrame.pack();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
    
}
