package model;
import javax.swing.*;
import java.awt.*;
public class Poring {
    private static int poring_count;
    private Icon icon;
    public Poring(){
        this.icon = new ImageIcon(this.getClass().getResource("/p.png"));
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public static int getPoring_count() {
        return poring_count;
    }

    public static void setPoring_count(int poring_count) {
        Poring.poring_count = poring_count;
    }
}
