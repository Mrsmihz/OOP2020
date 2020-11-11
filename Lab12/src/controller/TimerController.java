package controller;
import model.*;
import views.*;
public class TimerController {
    private MyTimer myTimer;
    private TimerGUI timerGUI;
    private Thread t1;
    public TimerController(){
        myTimer = new MyTimer();
        timerGUI = new TimerGUI();
        t1 = new Thread(myTimer);
        timerGUI.getMainPanel().add(myTimer);
        timerGUI.getMainFrame().validate();
        t1.start();
    }
}
