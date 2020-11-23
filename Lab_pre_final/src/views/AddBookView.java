package views;
import controller.BookController;

import javax.swing.*;
import java.awt.*;
public class AddBookView {
    private JFrame mainFrame;
    private JPanel mainPanel, btmPanel;
    private JLabel nameLabel, priceLabel, typeLabel;
    private JTextField nameTextField, priceTextField;
    private JComboBox<String> typeComboBox;
    private String[] typeMenu = {"General", "Computer", "Math&Sci", "Photo"};
    private JButton insertBtn;
    private BookController bc;
    public AddBookView(BookController bc){
        this.bc = bc;
        init();
    }
    private void init(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        btmPanel = new JPanel();
        nameLabel = new JLabel();
        priceLabel = new JLabel();
        typeLabel = new JLabel();
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        typeComboBox = new JComboBox<>(typeMenu);
        insertBtn = new JButton();
        setComponents();
    }
    private void setComponents(){
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(btmPanel, BorderLayout.SOUTH);

        mainPanel.setLayout(new GridLayout(3,2));
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        mainPanel.add(priceLabel);
        mainPanel.add(priceTextField);
        mainPanel.add(typeLabel);
        mainPanel.add(typeComboBox);

        btmPanel.setLayout(new GridBagLayout());
        btmPanel.add(insertBtn);

        insertBtn.setText("Insert");
        insertBtn.addActionListener(this.bc);
        nameLabel.setText("Name");
        priceLabel.setText("Price");
        typeLabel.setText("Type");

        mainFrame.pack();
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

    public JPanel getBtmPanel() {
        return btmPanel;
    }

    public void setBtmPanel(JPanel btmPanel) {
        this.btmPanel = btmPanel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public void setPriceLabel(JLabel priceLabel) {
        this.priceLabel = priceLabel;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(JLabel typeLabel) {
        this.typeLabel = typeLabel;
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getPriceTextField() {
        return priceTextField;
    }

    public void setPriceTextField(JTextField priceTextField) {
        this.priceTextField = priceTextField;
    }

    public JComboBox<String> getTypeComboBox() {
        return typeComboBox;
    }

    public void setTypeComboBox(JComboBox<String> typeComboBox) {
        this.typeComboBox = typeComboBox;
    }

    public String[] getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String[] typeMenu) {
        this.typeMenu = typeMenu;
    }

    public JButton getInsertBtn() {
        return insertBtn;
    }

    public void setInsertBtn(JButton insertBtn) {
        this.insertBtn = insertBtn;
    }

    public BookController getBc() {
        return bc;
    }

    public void setBc(BookController bc) {
        this.bc = bc;
    }
}
