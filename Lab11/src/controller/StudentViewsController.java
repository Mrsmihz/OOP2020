package controller;
import views.StudentViews;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import model.*;
public class StudentViewsController implements ActionListener, WindowListener {
    private JButton depositBtn, withdrawBtn;
    private StudentViews studentViews;
    private Font myFont;
    private final Path path = Paths.get("StudentM.dat");
    public StudentViewsController(){
        createComponents();
        setComponents();
    }
    private void createComponents(){
        studentViews = new StudentViews();
        myFont = new Font("Angsana New", Font.PLAIN, 30);
        depositBtn = new JButton("Deposit");
        withdrawBtn = new JButton("Withdraw");
    }
    private void setComponents(){
        studentViews.getMainFrame().addWindowListener(this);
        studentViews.getMainPanel().add(depositBtn);
        studentViews.getMainPanel().add(withdrawBtn);
        depositBtn.setFont(myFont);
        withdrawBtn.setFont(myFont);
        depositBtn.addActionListener(this);
        withdrawBtn.addActionListener(this);
        studentViews.getMoneyField().setText("0");
        studentViews.getMainFrame().pack();
        studentViews.getMainFrame().setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource().equals(depositBtn)){
            Integer temp = Integer.parseInt(studentViews.getMoneyField().getText())+100;
            studentViews.getMoneyField().setText(String.valueOf(temp));
        }
        else if (event.getSource().equals(withdrawBtn)){
            Integer temp = Integer.parseInt(studentViews.getMoneyField().getText());
            if (temp > 0){
                studentViews.getMoneyField().setText(String.valueOf(temp-100));
            }
            else{
                JOptionPane.showMessageDialog(studentViews.getMainFrame(), "Not enough money", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    private void saveObject(){
        String name = studentViews.getNameField().getText();
        Integer id = 0;
        try{
            id = Integer.parseInt(studentViews.getIdField().getText());
            studentViews.getMainFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        }
        catch (NumberFormatException e){
            studentViews.getMainFrame().setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            JOptionPane.showMessageDialog(studentViews.getMainFrame(), "ID format is invalid", "Alert", JOptionPane.WARNING_MESSAGE);
        }
        Integer money = Integer.parseInt(studentViews.getMoneyField().getText());
        Student s = new Student(name, id, money);
        try(FileOutputStream fout = new FileOutputStream(""+path.toAbsolutePath());
            ObjectOutput objectOut = new ObjectOutputStream(fout)){
            objectOut.writeObject(s);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void loadObject(){
        Student s;
        try(FileInputStream fin = new FileInputStream(""+path.toAbsolutePath());
            ObjectInputStream objectIn = new ObjectInputStream(fin)){
            s = (Student)objectIn.readObject();
            studentViews.getIdField().setText(String.valueOf(s.getId()));
            studentViews.getNameField().setText(s.getName());
            studentViews.getMoneyField().setText(String.valueOf(s.getMoney()));
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public void windowOpened(WindowEvent e) {
        loadObject();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        saveObject();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
