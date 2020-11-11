package controller;
import views.*;
import model.*;

import java.awt.event.*;

public class StopWatchController implements MouseListener {
    private MyStopWatch myStopWatch;
    private StopWatchGUI stopWatchGUI;
    private Thread t1;
    public StopWatchController(){
        myStopWatch = new MyStopWatch(this);
        stopWatchGUI = new StopWatchGUI();
        t1 = new Thread(myStopWatch);
        stopWatchGUI.getMainPanel().add(myStopWatch);
        stopWatchGUI.getMainFrame().validate();
        t1.start();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(myStopWatch)){
            if (myStopWatch.isPaused()){
                myStopWatch.resumeThread();
            }
            else{
                myStopWatch.pauseThread();
            }
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
