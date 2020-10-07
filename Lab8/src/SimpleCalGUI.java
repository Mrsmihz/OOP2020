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
import javax.swing.plaf.ColorUIResource;
import java.awt.event.*;
public class SimpleCalGUI implements ActionListener{
    private JFrame myFrame;
    private JPanel mainPanel, gridPanel, btnPanel;
    private JButton btnMultiply, btnDivide, btnSub, btnAdd;
    private JTextField firstText, secondText, resultText;
    private Font myFont;
    public SimpleCalGUI(){
        myFrame = new JFrame("SimpleCalGUI");
        myFrame.setLayout(new BorderLayout());
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFont = new Font("SansSerif", Font.BOLD, 20);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        myFrame.add(mainPanel);
        
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 1));
        
        btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnMultiply = new JButton("Multiply");
        btnDivide = new JButton("Divide");
        btnAdd = new JButton("Add");
        btnSub = new JButton("Subtract");
        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMultiply.addActionListener(this);
        btnDivide.addActionListener(this);
        btnPanel.add(btnAdd);
        btnPanel.add(btnSub);
        btnPanel.add(btnMultiply);
        btnPanel.add(btnDivide);
        
        firstText = new JTextField();
        secondText = new JTextField();
        resultText = new JTextField();
        firstText.setFont(myFont);
        secondText.setFont(myFont);
        resultText.setFont(myFont);
        resultText.setEditable(false);
        resultText.setBackground(new ColorUIResource(new Color(255, 255, 255)));
        firstText.setHorizontalAlignment(JTextField.RIGHT);
        secondText.setHorizontalAlignment(JTextField.RIGHT);
        resultText.setHorizontalAlignment(JTextField.RIGHT);
        gridPanel.add(firstText);
        gridPanel.add(secondText);
        gridPanel.add(btnPanel);
        gridPanel.add(resultText);
        
        mainPanel.add(gridPanel);
        myFrame.pack();
        myFrame.setResizable(false);
        myFrame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        System.out.println(e.getSource());
        double a = 0, b = 0;
        try{
            a = Double.parseDouble(firstText.getText());
            b = Double.parseDouble(secondText.getText());
        }
        catch (Exception error){
            firstText.setText("");
            secondText.setText("");
        }
        if (e.getSource().equals(btnAdd)){
            System.out.println("Add");
            resultText.setText(String.format("%f", a+b));
        }
        else if(e.getSource().equals(btnSub)){
            System.out.println("Subtract");
            resultText.setText(String.format("%f", a-b));
        }
        else if(e.getSource().equals(btnMultiply)){
            System.out.println("Multiply");
            resultText.setText(String.format("%f", a*b));
        }
        else if(e.getSource().equals(btnDivide)){
            System.out.println("Divide");
            resultText.setText(String.format("%f", a/b));
        }
    }
}
