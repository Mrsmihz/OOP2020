package views;
import controller.BookController;
import java.awt.*;
import javax.swing.*;

public class BookView {
    private JFrame mainFrame;
    private JPanel mainPanel, btmPanel;
    private JLabel nameLabel, priceLabel, typeLabel;
    private JTextField nameTextField, priceTextField, pagesTextField;
    private JComboBox<String> typeCombobox;
    private String[] menuType = {"General", "Computer", "Math&Sci", "Photo"};
    private JButton backBtn, forwardBtn, addBtn, updateBtn, deleteBtn;
    private BookController bc;
    public BookView(BookController bc){
        this.bc = bc;
        init();
    }
    private void init(){
        mainFrame = new JFrame();
        mainPanel = new JPanel();
        nameLabel = new JLabel();
        priceLabel = new JLabel();
        typeLabel = new JLabel();
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        pagesTextField = new JTextField();
        typeCombobox = new JComboBox<String>(menuType);
        backBtn = new JButton();
        forwardBtn = new JButton();
        addBtn = new JButton();
        updateBtn = new JButton();
        deleteBtn = new JButton();
        btmPanel = new JPanel();
        setComponents();
    }
    private void setComponents(){
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setTitle("BookView");
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.add(btmPanel, BorderLayout.SOUTH);

        mainPanel.setLayout(new GridLayout(3, 2));
        mainPanel.add(nameLabel);
        mainPanel.add(nameTextField);
        mainPanel.add(priceLabel);
        mainPanel.add(priceTextField);
        mainPanel.add(typeLabel);
        mainPanel.add(typeCombobox);

        GridBagConstraints gbc = new GridBagConstraints();
        btmPanel.setLayout(new GridBagLayout());
        btmPanel.add(backBtn, gbc);
        btmPanel.add(pagesTextField, gbc);
        btmPanel.add(forwardBtn, gbc);
        gbc.gridy = 1;
        btmPanel.add(addBtn, gbc);
        btmPanel.add(updateBtn, gbc);
        btmPanel.add(deleteBtn, gbc);

        typeCombobox.addItemListener(this.bc);
        nameLabel.setText("Name");
        priceLabel.setText("Price");
        typeLabel.setText("Type");
        backBtn.setText("<<<");
        backBtn.addActionListener(this.bc);
        pagesTextField.setText("0");
        pagesTextField.setPreferredSize(new Dimension(50, 22));
        pagesTextField.setHorizontalAlignment(SwingConstants.CENTER);
        pagesTextField.setEnabled(false);
        forwardBtn.setText(">>>");
        forwardBtn.addActionListener(this.bc);
        addBtn.setText("Add");
        addBtn.addActionListener(this.bc);
        updateBtn.setText("Update");
        updateBtn.addActionListener(this.bc);
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(this.bc);
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

    public JTextField getPagesTextField() {
        return pagesTextField;
    }

    public void setPagesTextField(JTextField pagesTextField) {
        this.pagesTextField = pagesTextField;
    }

    public JComboBox<String> getTypeCombobox() {
        return typeCombobox;
    }

    public void setTypeCombobox(JComboBox<String> typeCombobox) {
        this.typeCombobox = typeCombobox;
    }

    public String[] getMenuType() {
        return menuType;
    }

    public void setMenuType(String[] menuType) {
        this.menuType = menuType;
    }

    public JButton getBackBtn() {
        return backBtn;
    }

    public void setBackBtn(JButton backBtn) {
        this.backBtn = backBtn;
    }

    public JButton getForwardBtn() {
        return forwardBtn;
    }

    public void setForwardBtn(JButton forwardBtn) {
        this.forwardBtn = forwardBtn;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public void setAddBtn(JButton addBtn) {
        this.addBtn = addBtn;
    }

    public JButton getUpdateBtn() {
        return updateBtn;
    }

    public void setUpdateBtn(JButton updateBtn) {
        this.updateBtn = updateBtn;
    }

    public JButton getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(JButton deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

    public BookController getBc() {
        return bc;
    }

    public void setBc(BookController bc) {
        this.bc = bc;
    }
}
