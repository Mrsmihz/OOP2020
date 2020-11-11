package controller;
import views.*;
import model.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;

public class PoringController implements Runnable, MouseListener {
    private Poring poring;
    private PoringGUI poringGUI;
    public PoringController(){
    }

    @Override
    public void run() {
        this.poring = new Poring();
        this.poringGUI = new PoringGUI(this);
        int a = Poring.getPoring_count();
        Poring.setPoring_count(++a);
        poringGUI.getPoringLabel().setText(String.valueOf(Poring.getPoring_count()));
        poringGUI.getPoringLabel().setIcon(poring.getIcon());
        poringGUI.getMainFrame().validate();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(poringGUI.getPoringLabel())){
            poringGUI.getMainFrame().dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
