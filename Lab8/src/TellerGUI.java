/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FAITH
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TellerGUI implements ActionListener{
    private JFrame myFrame;
    private JPanel mainPanel, topPanel, bottomPanel;
    private JLabel balanceLabel, amountLabel;
    private JButton btnDeposit, btnWithdraw, btnExit;
    private JTextField balanceField, amountField;
    private Font myFont;
    private CheckingAccount acct;
    private Customer c1;
    private DecimalFormat dformat;
    public TellerGUI(){
        dformat = new DecimalFormat("#0.####");
        acct = new CheckingAccount(10000, "FAITH", 0);
        c1 = new Customer("FAITH", "SMTIH", acct);
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
        balanceField = new JTextField();
        amountField = new JTextField();
        balanceField.setHorizontalAlignment(JTextField.RIGHT);
        amountField.setHorizontalAlignment(JTextField.RIGHT);
        balanceLabel.setFont(myFont);
        amountLabel.setFont(myFont);
        balanceField.setFont(myFont);
        amountField.setFont(myFont);
        balanceField.setPreferredSize(new Dimension(200, 40));
        balanceField.setEditable(false);
        balanceField.setText(String.valueOf(c1.getAcct().getBalance()));
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
        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnExit.addActionListener(this);
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
    public void actionPerformed(ActionEvent e){
        double a = 0;
        if (e.getSource().equals(btnDeposit)){
            try {
                a = Double.parseDouble(amountField.getText());
            }
            catch (Exception excep){
                System.out.println(excep);
            }
            if (c1.getAcct().deposit(a)){
                balanceField.setText(String.valueOf(dformat.format(c1.getAcct().getBalance())));
                amountField.setText("");
            }
            else{
                return;
            }
        }
        else if (e.getSource().equals(btnWithdraw)){
            try {
                a = Double.parseDouble(amountField.getText());
            }
            catch (Exception excep){
                System.out.println(excep);
            }
            if (c1.getAcct().withdraw(a)){
                balanceField.setText(String.valueOf(dformat.format(c1.getAcct().getBalance())));
                amountField.setText("");
            }
            else{
                return;
            }
        }
        else if (e.getSource().equals(btnExit)){
            System.exit(1);
        }
    }
}
