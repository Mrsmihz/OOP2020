package model;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import controller.*;
public class MyStopWatch extends JLabel implements Runnable{
    private Font myFont;
    private int time;
    private StopWatchController sc;
    private boolean paused;
    private Object lock = new Object();
    public MyStopWatch(StopWatchController sc){
        this.sc = sc;
        myFont = new Font("Tahoma", Font.BOLD, 30);
        setFont(myFont);
        setHorizontalAlignment(CENTER);
        addMouseListener(this.sc);
    }
    private void checkPaused(){
        synchronized (this){
            while (paused){
                try{
                    this.wait();
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
        }
    }
    public void pauseThread(){
        paused = true;
    }
    public void resumeThread(){
        synchronized (this){
            paused = false;
            this.notify();
        }
    }
    @Override
    public void run() {
        try {
            while (true) {
                checkPaused();
                int temp = time;
                int hour = Math.floorDiv(temp, 3600);
                temp %= 3600;
                int min = Math.floorDiv(temp, 60);
                temp %= 60;
                int sec = temp;
                setText(String.format("%02d:%02d:%02d", hour, min, sec));
                time += 1;
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName());
            }
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public Font getMyFont() {
        return myFont;
    }

    public void setMyFont(Font myFont) {
        this.myFont = myFont;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public StopWatchController getSc() {
        return sc;
    }

    public void setSc(StopWatchController sc) {
        this.sc = sc;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
