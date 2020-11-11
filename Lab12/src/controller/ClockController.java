package controller;
import views.*;
import model.*;
public class ClockController {
    private ClockGUI clockGUI;
    private MyClock myClock;
    private Thread t1;
    public ClockController(){
        clockGUI = new ClockGUI();
        myClock = new MyClock();
        t1 = new Thread(myClock);
        clockGUI.getMainPanel().add(myClock);
        clockGUI.getMainFrame().validate();
        t1.start();
    }
}
