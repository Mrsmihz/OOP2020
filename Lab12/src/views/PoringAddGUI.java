package views;
import javax.swing.*;
import java.awt.*;
import controller.*;
public class PoringAddGUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton addBtn;
    private PoringAddController pc;
    public PoringAddGUI(PoringAddController pc){
        this.pc = pc;
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        addBtn = new JButton("Add");

        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel);

        mainPanel.setLayout(new GridBagLayout());
        mainPanel.add(addBtn);

        addBtn.setPreferredSize(new Dimension(200, 50));
        addBtn.addActionListener(this.pc);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.pack();
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

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public PoringAddController getPc() {
        return pc;
    }

    public void setPc(PoringAddController pc) {
        this.pc = pc;
    }
}
