package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class ChatDemo{
    private JFrame mainFrame;
    private JPanel mainPanel, btnPanel;
    private JTextArea mainTextArea;
    private JTextField inputField;
    private JScrollPane scrollPane;
    private Font myFont;
    public ChatDemo(){
        createComponents();
        setComponents();
    }
    private void createComponents(){
        myFont = new Font("Angsana New", Font.PLAIN, 25);
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        mainTextArea = new JTextArea();
        inputField = new JTextField();
        btnPanel = new JPanel();
        scrollPane = new JScrollPane(mainTextArea);
    }
    private void setComponents(){
        mainFrame.setTitle("ChatDemoGUI");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);
        mainFrame.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());

        mainPanel.add(scrollPane, BorderLayout.NORTH);
        mainPanel.add(inputField, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        mainTextArea.setEditable(false);
        mainTextArea.setFont(myFont);

        scrollPane.setPreferredSize(new Dimension(450, 200));

        inputField.setPreferredSize(new Dimension(450, 50));
        inputField.setFont(myFont);

        btnPanel.setLayout(new GridBagLayout());

    }
    public JTextArea getMainTextArea(){
        return this.mainTextArea;
    }
    public JTextField getInputField(){
        return this.inputField;
    }
    public JFrame getMainFrame(){
        return this.mainFrame;
    }
    public JPanel getBtnPanel(){
        return this.btnPanel;
    }
    public JScrollPane getScrollPane(){
        return this.scrollPane;
    }
}
