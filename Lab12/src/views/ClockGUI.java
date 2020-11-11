package views;
import java.awt.*;
import javax.swing.*;
public class ClockGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    public ClockGUI(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();

        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());

        mainFrame.setSize(200, 100);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    public JFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(JFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }
}
