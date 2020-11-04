package controller;
import model.*;
import views.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class ChatDemoController implements ActionListener {
    private JButton btnSubmit, btnReset;
    private Font myFont;
    private ChatDemo chatGUI;
    private final Path path = Paths.get("ChatDemo.dat");
    public ChatDemoController(){
        createComponents();
        setComponents();
        showMessage();
    }
    private void createComponents(){
        myFont = new Font("Angsana New", Font.PLAIN, 25);
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        chatGUI = new ChatDemo();
    }
    private void setComponents(){
        btnSubmit.setFont(myFont);
        btnReset.setFont(myFont);
        btnSubmit.addActionListener(this);
        btnReset.addActionListener(this);
        chatGUI.getBtnPanel().add(btnSubmit);
        chatGUI.getBtnPanel().add(btnReset);
        chatGUI.getMainFrame().pack();
        chatGUI.getMainFrame().setLocationRelativeTo(null);
        chatGUI.getMainFrame().setVisible(true);
    }
    public void actionPerformed(ActionEvent event){
        if (event.getSource().equals(btnSubmit)){
            if (!chatGUI.getInputField().getText().equals("")){
                Message msg = new Message(chatGUI.getInputField().getText());
                saveMessage(msg);
                showMessage(msg);
                chatGUI.getInputField().setText("");
                toBottom();
            }
        }
        else if (event.getSource().equals(btnReset)){
            chatGUI.getMainTextArea().setText("");
            resetData();
        }
    }
    private void saveMessage(Message msg){
        ArrayList<Message> list = getObject();
        try(FileOutputStream fout = new FileOutputStream(""+path.toAbsolutePath());
            ObjectOutputStream objectOut = new ObjectOutputStream(fout)){
            list.add(msg);
            objectOut.writeObject(list);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private ArrayList<Message> getObject(){
        ArrayList<Message> obj;
        try (FileInputStream fin = new FileInputStream(""+path.toAbsolutePath());
            ObjectInputStream objectIn = new ObjectInputStream(fin)){
            obj = (ArrayList<Message>)objectIn.readObject();
        }
        catch (ClassNotFoundException | IOException c){
            obj = new ArrayList<>();
        }
        return obj;
    }
    private void showMessage(){
        ArrayList<Message> list = getObject();
        if (list.size() != 0){
            for (Message msg : list){
                chatGUI.getMainTextArea().append(msg.getMsg()+"\n");
            }
        }
    }
    private void showMessage(Message msg){
        chatGUI.getMainTextArea().append(msg.getMsg()+"\n");
    }
    private void toBottom(){
        chatGUI.getMainFrame().revalidate();
        JScrollBar vertical = chatGUI.getScrollPane().getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
    private void resetData(){
        try(FileOutputStream fout = new FileOutputStream(""+path.toAbsolutePath());
            ObjectOutputStream objectOut = new ObjectOutputStream(fout)){
            objectOut.writeObject(new ArrayList<>());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
