package views;
import controller.TextEditorController;
import java.awt.*;
import javax.swing.*;
public class TextEditor {
    private JFrame mainFrame;
    private JPanel mainPanel, statusBar;
    private JLabel statusLabel;
    private JTextArea textArea;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem newFile, openFile, saveFile, closeProgram, saveAs;
    private JFileChooser fileChooser;
    private TextEditorController tc;
    public TextEditor(TextEditorController tc){
        this.tc = tc;
        init();
    }
    private void init(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        textArea = new JTextArea();
        menuBar = new JMenuBar();
        menu = new JMenu();
        fileChooser = new JFileChooser();
        newFile = new JMenuItem();
        openFile = new JMenuItem();
        saveFile = new JMenuItem();
        saveAs = new JMenuItem();
        closeProgram = new JMenuItem();
        statusBar = new JPanel();
        statusLabel = new JLabel();
        setComponents();
    }
    private void setComponents(){
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setTitle("Text Editor");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(statusBar, BorderLayout.SOUTH);
        mainFrame.addWindowListener(this.tc);
        statusBar.setPreferredSize(new Dimension(mainFrame.getWidth(), 20));
        statusBar.setLayout(new BoxLayout(statusBar, BoxLayout.X_AXIS));
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusLabel.setFont(new Font("Angsana New", Font.PLAIN, 16));
        statusBar.add(statusLabel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea);

        textArea.setPreferredSize(new Dimension(800, 600));
        textArea.setFont(new Font("Angsana New", Font.PLAIN, 30));

        mainFrame.setJMenuBar(menuBar);
        menuBar.add(menu);

        menu.setText("File");
        newFile.setText("New");
        newFile.addActionListener(this.tc);
        openFile.setText("Open");
        openFile.addActionListener(this.tc);
        saveFile.setText("Save");
        saveFile.addActionListener(this.tc);
        saveAs.setText("Save as..");
        saveAs.addActionListener(this.tc);
        closeProgram.setText("Close");
        closeProgram.addActionListener(this.tc);
        menu.add(newFile);
        menu.add(openFile);
        menu.add(saveFile);
        menu.add(saveAs);
        menu.addSeparator();
        menu.add(closeProgram);

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

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenu getMenu() {
        return menu;
    }

    public void setMenu(JMenu menu) {
        this.menu = menu;
    }

    public JMenuItem getNewFile() {
        return newFile;
    }

    public void setNewFile(JMenuItem newFile) {
        this.newFile = newFile;
    }

    public JMenuItem getOpenFile() {
        return openFile;
    }

    public void setOpenFile(JMenuItem openFile) {
        this.openFile = openFile;
    }

    public JMenuItem getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(JMenuItem saveFile) {
        this.saveFile = saveFile;
    }

    public JMenuItem getCloseProgram() {
        return closeProgram;
    }

    public void setCloseProgram(JMenuItem closeProgram) {
        this.closeProgram = closeProgram;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }

    public void setFileChooser(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

    public JPanel getStatusBar() {
        return statusBar;
    }

    public void setStatusBar(JPanel statusBar) {
        this.statusBar = statusBar;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public JMenuItem getSaveAs() {
        return saveAs;
    }

    public void setSaveAs(JMenuItem saveAs) {
        this.saveAs = saveAs;
    }

    public TextEditorController getTc() {
        return tc;
    }

    public void setTc(TextEditorController tc) {
        this.tc = tc;
    }
}
