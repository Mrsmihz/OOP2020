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
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class CalculatorSample implements ActionListener{
    private JFrame frame;
    private JPanel mainpanel, toppanel, bottompanel;
    private JTextField mainText;
    private Font myFont, myBtnFont;
    private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnMultiply, btnAdd, btnSub, btnDivide, btnClear, btnResult;
    private String temp1 = "", temp2 = "";
    private boolean add = false;
    private boolean sub = false;
    private boolean divide = false;
    private boolean multiply = false;
    private boolean subzero = false;
    private DecimalFormat dformat;
    public CalculatorSample(){
        dformat = new DecimalFormat("#0.####");
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
        btn.addActionListener(this);
        return btn;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btn1)){
            temp1 += "1";
        }
        else if (e.getSource().equals(btn2)){
            temp1 += "2";
        }
        else if (e.getSource().equals(btn3)){
            temp1 += "3";
        }
        else if (e.getSource().equals(btn4)){
            temp1 += "4";
        }
        else if (e.getSource().equals(btn5)){
            temp1 += "5";
        }
        else if (e.getSource().equals(btn6)){
            temp1 += "6";
        }
        else if(e.getSource().equals(btn7)){
            temp1 += "7";
        }
        else if(e.getSource().equals(btn8)){
            temp1 += "8";
        }
        else if (e.getSource().equals(btn9)){
            temp1 += "9";
        }
        else if(e.getSource().equals(btn0)){
            if (temp1.equals("")){
                temp1 += "0.";
            }
            else{
                temp1 += "0";
            }
        }
        else if (e.getSource().equals(btnClear)){
            temp1 = "";
            temp2 = "";
            add=sub=divide=multiply=false;
        }
        else if (e.getSource().equals(btnAdd)){
            if (!temp2.equals("") && !temp1.equals("")){
                Calculate('+');
                temp2 = temp1;
                temp1 = "";
                return;
            }
            else if (temp1.equals("")){
                mainText.setText(temp1);
                return;
            }
            temp2 = temp1;
            temp1 = "";
            sub=divide=multiply=false;
            add = true;
        }
        else if (e.getSource().equals(btnSub)){
            System.out.println(subzero);
            System.out.println(temp1);
            System.out.println(temp2);
            if (!temp2.equals("") && !temp2.equals("-") && !temp1.equals("") && !temp1.equals("-")){
                Calculate('-');
                temp2 = temp1;
                temp1 = "";
                return;
            }
            else if (temp1.equals("") || temp1.equals("-")){
                if (subzero){
                    temp1 += "-";
                    subzero = false;
                }
                else{
                    temp1 = "";
                    subzero = true;
                }
                mainText.setText(temp1);
                return;
            }
            temp2 = temp1;
            temp1 = "";
            add=divide=multiply=false;
            sub = true;
        }
        else if (e.getSource().equals(btnMultiply)){
            System.out.println(temp2);
            System.out.println(temp1);
            if (!temp2.equals("") && !temp1.equals("")){
                Calculate('*');
                temp2 = temp1;
                temp1 = "";
                return;
            }
            else if (temp1.equals("")){
                mainText.setText(temp1);
                return;
            }
            temp2 = temp1;
            temp1 = "";
            add=sub=divide=false;
            multiply = true;
        }
        else if (e.getSource().equals(btnDivide)){
            if (!temp2.equals("") && !temp1.equals("")){
                Calculate('/');
                temp2 = temp1;
                temp1 = "";
                return;
            }
            else if (temp1.equals("")){
                mainText.setText(temp1);
                return;
            }
            temp2 = temp1;
            temp1 = "";
            add=sub=multiply=false;
            divide = true;
        }
        else if (e.getSource().equals(btnResult)){
            System.out.println("result");
            check();
        }
        mainText.setText(temp1);
    }
    private void Calculate(char symbol){
        double a = 0, b=0;
        if (temp1.equals("")){
            temp1 = "0";
        }
        else if (temp2.equals("")){
            temp2 = "0";
        }
        try{
            a = Double.parseDouble(temp1);
            b = Double.parseDouble(temp2);
        }
        catch (Exception e){
            System.out.println(e);
        }
        if (symbol == '+'){
            temp1 = String.valueOf(dformat.format(a+b));
            temp2 = "";
        }
        else if (symbol == '-'){
            temp1 = String.valueOf(dformat.format(b-a));
            temp2 = "";
        }
        else if (symbol == '*'){
            temp1 = String.valueOf(dformat.format(a*b));
            temp2 = "";
        }
        else if (symbol == '/'){
            try{
                temp1 = String.valueOf(dformat.format(b/a));
                temp2 = "";
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        mainText.setText(temp1);
    }
    private void check(){
        if (add){
            Calculate('+');
        }
        else if (sub){
            Calculate('-');
        }
        else if (divide){
            Calculate('/');
        }
        else if (multiply){
            Calculate('*');
        }
    }
}

