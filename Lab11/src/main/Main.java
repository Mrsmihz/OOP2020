package main;
import com.formdev.flatlaf.intellijthemes.*;
import controller.*;
import views.*;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(new FlatArcDarkOrangeIJTheme());
        }
        catch (UnsupportedLookAndFeelException e){
            e.printStackTrace();
        }
        //new ChatDemoController();
        new StudentViewsController();
    }
}
