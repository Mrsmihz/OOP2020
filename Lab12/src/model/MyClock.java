package model;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class MyClock extends JLabel implements Runnable{
    private Font myFont;
    private int count = 0;
    public MyClock(){
        myFont = new Font("Tahoma", Font.BOLD, 30);
        setFont(myFont);
        setHorizontalAlignment(CENTER);
    }
    public void run() {
        while (true){
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            setText(String.format("%02d:%02d:%02d", hour, min, sec));
            System.out.println(count++);
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
