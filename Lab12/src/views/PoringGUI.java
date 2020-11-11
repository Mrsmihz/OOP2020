package views;
import controller.PoringController;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PoringGUI{
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel poringLabel;
    private PoringController pc;
    private Random random;
    private int x, y;
    public PoringGUI(PoringController pc){
        this.pc = pc;
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        poringLabel = new JLabel();
        random = new Random();
        x = random.nextInt(1900+1-150)+150;
        y = random.nextInt(900+1-150)+150;
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(poringLabel);
        poringLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.setResizable(false);
        poringLabel.addMouseListener(this.pc);
        mainFrame.setSize(150,150);
        mainFrame.setLocation(x, y);
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

    public JLabel getPoringLabel() {
        return poringLabel;
    }

    public void setPoringLabel(JLabel poringLabel) {
        this.poringLabel = poringLabel;
    }
}
