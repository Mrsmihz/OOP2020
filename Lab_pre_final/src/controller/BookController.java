package controller;
import views.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.*;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class BookController implements ActionListener, ItemListener {
    private BookView bookView;
    private AddBookView addBookView;
    private final Path path = Paths.get("Book.data");
    private ArrayList<Book> bookData;
    private int indexOfBook = 0;
    public BookController(){
        this.bookView = new BookView(this);
        this.addBookView = new AddBookView(this);
        onStartUp();
    }

    public BookView getBookView() {
        return bookView;
    }

    public void setBookView(BookView bookView) {
        this.bookView = bookView;
    }
    private void onStartUp(){
        this.bookData = getObject();
        if (bookData.size()>0){
            Book book = bookData.get(indexOfBook);
            this.bookView.getNameTextField().setText(book.getName());
            this.bookView.getPriceTextField().setText(String.valueOf(book.getPrice()));
            this.bookView.getTypeCombobox().setSelectedItem(book.getType());
            this.bookView.getPagesTextField().setText(String.valueOf(indexOfBook));
            this.bookView.getMainPanel().validate();
        }
    }
    private ArrayList<Book> getObject(){
        ArrayList<Book> obj;
        try(FileInputStream input = new FileInputStream(""+path.toAbsolutePath());
            ObjectInputStream objectIn = new ObjectInputStream(input);){
            obj = (ArrayList<Book>)objectIn.readObject();
        }
        catch (ClassNotFoundException | IOException e){
            obj = new ArrayList<Book>();
        }
        return obj;
    }
    private boolean saveObject(Book b){
        ArrayList<Book> list = getObject();
        try(FileOutputStream output = new FileOutputStream(""+path.toAbsolutePath());
            ObjectOutputStream objectOut = new ObjectOutputStream(output);){
            list.add(b);
            objectOut.writeObject(list);
            return true;
        }
        catch(IOException e){
            e.printStackTrace();
            return false;
        }
    }
    private void addBook(){
        String name = addBookView.getNameTextField().getText();
        String type = (String)addBookView.getTypeComboBox().getSelectedItem();
        try{
            double price = Double.parseDouble(addBookView.getPriceTextField().getText());
            Book book = new Book(name, type, price);
            if (saveObject(book)){
                if (indexOfBook == 0){
                    onStartUp();
                }
                JOptionPane.showMessageDialog(addBookView.getMainFrame(), "Done it.");
                this.bookData = getObject();
                this.addBookView.getNameTextField().setText("");
                this.addBookView.getPriceTextField().setText("");
                this.addBookView.getTypeComboBox().setSelectedItem("General");
                this.addBookView.getMainFrame().dispose();
            }
            else{
                JOptionPane.showMessageDialog(addBookView.getMainFrame(), "Save failed.");
            }
        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(addBookView.getMainFrame(), "Price is incorrect format.");
        }
    }
    private void reWriteObject(ArrayList<Book> book){
        try(FileOutputStream output = new FileOutputStream(""+path.toAbsolutePath());
            ObjectOutputStream objOut = new ObjectOutputStream(output);){
            objOut.writeObject(book);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private void deleteBook(){
        try {
            bookData.remove(indexOfBook--);
            reWriteObject(bookData);
            bookData = getObject();
            if (indexOfBook == -1 && bookData.size() == 0) {
                indexOfBook = 0;
                bookView.getNameTextField().setText("");
                bookView.getPriceTextField().setText("");
                bookView.getTypeCombobox().setSelectedItem("General");
                bookView.getPagesTextField().setText(String.valueOf(indexOfBook));
            } else if (indexOfBook == -1) {
                indexOfBook = 0;
                onStartUp();
            } else {
                onStartUp();
            }
            JOptionPane.showMessageDialog(bookView.getMainFrame(), "Deleted done.");
        }
        catch (IndexOutOfBoundsException e){
            indexOfBook = 0;
            JOptionPane.showMessageDialog(bookView.getMainFrame(), "Book Collections is empty.");
        }

    }
    private void updateBook(){
        String name = bookView.getNameTextField().getText();
        String type = (String)bookView.getTypeCombobox().getSelectedItem();
        try {
            double price = Double.parseDouble(bookView.getPriceTextField().getText());
            Book book = new Book(name, type, price);
            if (bookData.size() > 0){
                this.bookData.set(indexOfBook, book);
                reWriteObject(this.bookData);
                this.bookData = getObject();
                JOptionPane.showMessageDialog(bookView.getMainFrame(), "Updated Book Collections.");
            }
            else{
                JOptionPane.showMessageDialog(bookView.getMainFrame(), "Collections is empty.");
            }

        }
        catch (NumberFormatException e){
            JOptionPane.showMessageDialog(bookView.getMainFrame(), "Price is incorrect format.");

        }
    }
    private void goForward(){
        if (indexOfBook < bookData.size()-1){
            Book book = bookData.get(++indexOfBook);
            this.bookView.getPagesTextField().setText(String.valueOf(indexOfBook));
            this.bookView.getNameTextField().setText(book.getName());
            this.bookView.getPriceTextField().setText(String.valueOf(book.getPrice()));
            this.bookView.getTypeCombobox().setSelectedItem(book.getType());
            this.bookView.getMainPanel().validate();
        }
    }
    private void goBack(){
        if (indexOfBook > 0) {
            Book book = bookData.get(--indexOfBook);
            this.bookView.getPagesTextField().setText(String.valueOf(indexOfBook));
            this.bookView.getNameTextField().setText(book.getName());
            this.bookView.getPriceTextField().setText(String.valueOf(book.getPrice()));
            this.bookView.getTypeCombobox().setSelectedItem(book.getType());
            this.bookView.getMainPanel().validate();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(bookView.getAddBtn())){
            addBookView.getMainFrame().setLocationRelativeTo(bookView.getMainFrame());
            addBookView.getMainFrame().setVisible(true);
        }
        else if (e.getSource().equals(addBookView.getInsertBtn())){
            addBook();
        }
        else if (e.getSource().equals(bookView.getForwardBtn())){
            goForward();
        }
        else if (e.getSource().equals(bookView.getBackBtn())){
            goBack();
        }
        else if (e.getSource().equals(bookView.getUpdateBtn())){
            updateBook();
        }
        else if (e.getSource().equals(bookView.getDeleteBtn())){
            deleteBook();
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
