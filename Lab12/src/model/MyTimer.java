package model;
import java.awt.*;
import javax.swing.*;
public class MyTimer extends JLabel implements Runnable{
    private Font myFont;
    private int time;
    public MyTimer(){
        myFont = new Font("Tahoma", Font.BOLD, 30);
        setFont(myFont);
        setHorizontalAlignment(CENTER);
    }

    @Override
    public void run() {
        while (true){
            int temp = time;
            int hour = Math.floorDiv(temp, 3600);
            temp %= 3600;
            int min = Math.floorDiv(temp, 60);
            temp %= 60;
            int sec = temp;
            setText(String.format("%02d:%02d:%02d", hour, min, sec));
            time += 1;
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
