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
public class CalculatorSample {
    private JFrame frame;
    private JPanel mainpanel, toppanel, bottompanel;
    private JTextField mainText;
    private Font myFont, myBtnFont;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMultiply, btnAdd, btnSub, btnDivide, btnClear, btnResult;
    public CalculatorSample(){
        frame = new JFrame("Calculator Sample");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        
        
        toppanel = new JPanel();
        toppanel.setLayout(new BorderLayout());
        toppanel.setPreferredSize(new Dimension(400, 50));
        
        
        
        mainText = new JTextField();
        mainText.setHorizontalAlignment(JTextField.RIGHT);
        myFont = new Font("SansSerif", Font.BOLD, 24);
        mainText.setFont(myFont);
        mainText.setEditable(false);
        toppanel.add(mainText);
        mainpanel.add(toppanel, BorderLayout.NORTH);
        
        
        bottompanel = new JPanel();
        bottompanel.setLayout(new GridLayout(4,4));
        myBtnFont = new Font("SansSerif", Font.BOLD, 24);
        createAllButton();
        addAllButton();
        mainpanel.add(bottompanel, BorderLayout.CENTER);
        
        frame.setResizable(false);
        frame.add(mainpanel);
        frame.setVisible(true);
        
        
        
    }
    private void addAllButton(){
        bottompanel.add(btn7);
        bottompanel.add(btn8);
        bottompanel.add(btn9);
        bottompanel.add(btnAdd);
        bottompanel.add(btn4);
        bottompanel.add(btn5);
        bottompanel.add(btn6);
        bottompanel.add(btnSub);
        bottompanel.add(btn1);
        bottompanel.add(btn2);
        bottompanel.add(btn3);
        bottompanel.add(btnMultiply);
        bottompanel.add(btn0);
        bottompanel.add(btnClear);
        bottompanel.add(btnResult);
        bottompanel.add(btnDivide);
    }
    private void createAllButton(){
        btn1 = createButton("1");
        btn2 = createButton("2");
        btn3 = createButton("3");
        btn4 = createButton("4");
        btn5 = createButton("5");
        btn6 = createButton("6");
        btn7 = createButton("7");
        btn8 = createButton("8");
        btn9 = createButton("9");
        btn0 = createButton("0");
        btnMultiply = createButton("x");
        btnDivide = createButton("/");
        btnAdd = createButton("+");
        btnSub = createButton("-");
        btnClear = createButton("C");
        btnResult = createButton("=");
    }
    private JButton createButton(String name){
        JButton btn = new JButton(name);
        btn.setFont(myBtnFont);
        return btn;
    }
}
