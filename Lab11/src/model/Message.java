package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message implements Serializable {
    private String dateTime, msg;
    public Message(String msg){
        this.msg = msg;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.dateTime = dtf.format(LocalDateTime.now());
    }
    public String getMsg(){
        return String.format("%s : %s", this.dateTime, this.msg);
    }
}
