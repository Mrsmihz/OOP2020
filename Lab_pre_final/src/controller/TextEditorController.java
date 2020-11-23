package controller;

import model.Message;
import views.TextEditor;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public class TextEditorController implements ActionListener, WindowListener{
    private TextEditor textEditor;
    private JFileChooser fc;
    private File opened;
    public TextEditorController(){
        this.textEditor = new TextEditor(this);
        this.fc = textEditor.getFileChooser();
        init();
    }
    private void init(){
        FileNameExtensionFilter filter = new FileNameExtensionFilter("dat", "dat");
        fc.addChoosableFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        File workingdir = new File(System.getProperty("user.dir"));
        fc.setCurrentDirectory(workingdir);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(textEditor.getNewFile())){
            textEditor.getTextArea().setText("");
            this.opened = null;
            showStatus("New File initialize..!!");
        }
        else if (e.getSource().equals(textEditor.getOpenFile())){
            int selected = fc.showOpenDialog(textEditor.getMainFrame());
            if (selected == JFileChooser.APPROVE_OPTION){
                File file = fc.getSelectedFile();
                this.opened = file;
                openFile(file);
                showStatus("File Opened..!!");
            }
        }
        else if (e.getSource().equals(textEditor.getSaveFile())){
            if (opened != null) {
                saveFile(opened);
            }
            else{
                saveFile();
            }
            showStatus("File is saved..!!");
        }
        else if (e.getSource().equals(textEditor.getSaveAs())){
                saveFile();
                showStatus("File is saved..!!");
        }
        else if (e.getSource().equals(textEditor.getCloseProgram())){
            int selected = JOptionPane.showConfirmDialog(textEditor.getMainFrame(), "Do you wanna save ?", "KUY",JOptionPane.YES_NO_CANCEL_OPTION);
            if (selected == JOptionPane.YES_OPTION){
                if (opened != null){
                    saveFile(opened);
                }
                else{
                    saveFile();
                }
                System.exit(0);
            }
            else if (selected == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
    }
    private void openFile(File f){
        try(FileInputStream input = new FileInputStream(f);
            ObjectInputStream data = new ObjectInputStream(input);){
            Message msg = (Message)data.readObject();
            textEditor.getTextArea().setText(msg.getMsg());
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private void saveFile(){
        int selected = fc.showSaveDialog(textEditor.getMainFrame());
        File file;
        if (selected == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            this.opened = file;
        }
        else{
            return;
        }
        try(FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream objout = new ObjectOutputStream(output);){
            Message msg = new Message(textEditor.getTextArea().getText());
            objout.writeObject(msg);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void saveFile(File f){
        try(FileOutputStream output = new FileOutputStream(f);
            ObjectOutputStream objout = new ObjectOutputStream(output);){
            Message msg = new Message(textEditor.getTextArea().getText());
            objout.writeObject(msg);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void showStatus(String s){
        textEditor.getStatusLabel().setText(s);
        textEditor.getStatusLabel().validate();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                textEditor.getStatusLabel().setText("");
            }
        }, 5000);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (e.getSource().equals(textEditor.getMainFrame())){
            int selected = JOptionPane.showConfirmDialog(textEditor.getMainFrame(), "Do you wanna save ?", "KUY",JOptionPane.YES_NO_CANCEL_OPTION);
            if (selected == JOptionPane.YES_OPTION){
                if (opened != null){
                    saveFile(opened);
                }
                else{
                    saveFile();
                }
                System.exit(0);
            }
            else if (selected == JOptionPane.NO_OPTION){
                System.exit(0);
            }
        }
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
