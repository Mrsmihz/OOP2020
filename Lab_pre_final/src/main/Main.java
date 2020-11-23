package main;
import views.*;
import java.util.*;
import javax.swing.*;
import controller.*;
public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //new TextEditorController();
        new BookController();
    }
}
