public class Plane extends Vehicle{

    public void setPlaneInfo(int s, String t){
        this.setFuel(s);
        this.setTopSpeed(t);
    }
    public void Fly(){
        if (this.getFuel() - 200 >= 0){
            this.setFuel(this.getFuel()-200);
            System.out.println("Fly.");
        }
        else{
            System.out.println("Please add fuel.");
        }
    }
    public void showPlaneInfo(){
        System.out.printf("Plane detail is, Fuel is %d litre and Top Speed is %s m/s\n", this.getFuel(), this.getTopSpeed());
    }
}
