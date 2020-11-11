package controller;
import model.*;
import views.*;

import java.awt.event.*;
import views.*;
public class PoringAddController implements ActionListener {
    private PoringAddGUI poringAddGUI;
    public PoringAddController(){
        this.poringAddGUI = new PoringAddGUI(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(poringAddGUI.getAddBtn())){
            createPoring();
        }
    }
    private void createPoring(){
        Thread t1 = new Thread(new PoringController());
        t1.start();
    }
}
