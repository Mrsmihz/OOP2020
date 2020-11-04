package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int id, money;
    public Student(){

    }
    public Student(String name, int id, int money){
        this.name = name;
        this.id = id;
        this.money = money;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
