package views;
import controller.StudentViewsController;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class StudentViews{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel nameLabel, idLabel, moneyLabel;
    private JTextField idField, nameField, moneyField;
    private Font myFont;

    public StudentViews(){
        createComponents();
        setComponents();
    }
    private void createComponents(){
        myFont = new Font("Angsana New", Font.PLAIN, 30);
        mainFrame = new JFrame("StudentView");
        mainPanel = new JPanel();
        nameLabel = new JLabel("Name : ");
        idLabel = new JLabel("ID : ");
        moneyLabel = new JLabel("Money : ");
        idField = new JTextField();
        nameField = new JTextField();
        moneyField = new JTextField();
    }
    private void setComponents(){
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel);


        mainPanel.setLayout(new GridLayout(4, 2));

        mainPanel.add(idLabel);
        mainPanel.add(idField);
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(moneyLabel);
        mainPanel.add(moneyField);

        idLabel.setFont(myFont);
        nameLabel.setFont(myFont);
        moneyLabel.setFont(myFont);

        idField.setFont(myFont);
        nameField.setFont(myFont);
        moneyField.setFont(myFont);

        idField.setPreferredSize(new Dimension(200, 50));
        moneyField.setEnabled(false);
    }
    public JPanel getMainPanel(){
        return this.mainPanel;
    }
    public JFrame getMainFrame(){
        return this.mainFrame;
    }

    public JTextField getIdField() {
        return idField;
    }

    public void setIdField(JTextField idField) {
        this.idField = idField;
    }

    public JTextField getNameField() {
        return nameField;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }

    public void setMoneyField(JTextField moneyField) {
        this.moneyField = moneyField;
    }

    public JTextField getMoneyField(){
        return this.moneyField;
    }
}
