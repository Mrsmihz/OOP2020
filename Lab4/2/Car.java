public class Car extends Vehicle{
    private String typeEngine;

    public void SetTypeEngine(String t){
        this.typeEngine = t;
    }
    public String getTypeEngine(){
        return this.typeEngine;
    }
    public void setCarInfo(int s, String t, String y){
        this.setFuel(s);
        this.setTopSpeed(t);
        this.SetTypeEngine(y);
    }
    public void Move(){
        if (this.getFuel() - 50 >= 0){
            this.setFuel(this.getFuel()-50);
            System.out.println("Move.");
        }
        else{
            System.out.println("Please add fuel.");
        }
    }
    public void showCarInfo(){
        System.out.printf("Car engine is %s, ", this.getTypeEngine());
        this.showInfo();
    }
}
