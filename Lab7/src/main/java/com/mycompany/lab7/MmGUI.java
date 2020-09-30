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
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
public class MmGUI {
    private JFrame myFrame;
    private JMenuBar myMenuBar;
    private JMenu fileMenu, editMenu, viewMenu, newMenu;
    private JMenuItem windowItem, msgItem, openItem, saveItem, exitItem;
    private JPanel mainPanel;
    private JDesktopPane myDesktopPane;
    public static int openFrame = 1;
    public MmGUI(){
        myFrame = new JFrame("MMGUI");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(1024, 800);
        
        myMenuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        viewMenu = new JMenu("View");
        newMenu = new JMenu("New");
        
        windowItem = new JMenuItem("Window");
        msgItem = new JMenuItem("Message");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        newMenu.add(windowItem);
        newMenu.add(msgItem);
        fileMenu.add(newMenu);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
        myMenuBar.add(fileMenu);
        myMenuBar.add(editMenu);
        myMenuBar.add(viewMenu);
        myFrame.setJMenuBar(myMenuBar);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        myFrame.add(mainPanel);
        
        myDesktopPane = new JDesktopPane();
        myDesktopPane.setBackground(new ColorUIResource(new Color(0, 0, 0)));
        
        
        JInternalFrame frame1 = createInternalFrame();
        createFrameContents(frame1, "TEST1");
        frame1.setVisible(true);
        JInternalFrame frame2 = createInternalFrame();
        createFrameContents(frame2, "TEST2");
        frame2.setVisible(true);
        JInternalFrame frame3 = createInternalFrame();
        createFrameContents(frame3, "TEST3");
        frame3.setVisible(true);
        changeLocation(frame1, frame2);
        changeLocation(frame2, frame3);
        myDesktopPane.add(frame1);
        myDesktopPane.add(frame2);
        myDesktopPane.add(frame3);
        
        mainPanel.add(myDesktopPane);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
    }
    private JInternalFrame createInternalFrame(){
        JInternalFrame frame = new JInternalFrame("Application " + openFrame++, false, true, true, true);
        frame.setSize(200, 200);
        return frame;
    }
    private void createFrameContents(JInternalFrame frame, String contents){
        frame.getContentPane().add(new JLabel(contents));
    }
    private void changeLocation(JInternalFrame frameBefore, JInternalFrame frameAfter){
        int x = frameBefore.getX() + frameBefore.getWidth()+10;
        int y = frameBefore.getY();
        frameAfter.setLocation(x, y);
    }
}
