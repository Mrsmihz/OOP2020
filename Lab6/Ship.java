public class Ship extends Vehicle implements Floatable{
    public Ship(){
        super(0);
    }
    public Ship(double fuel){
        super(fuel);
    }
    public void move(){
        fl0at();
    }
    public void move(int distance){
        for (int i=0;i<distance;i++){
            if (super.getFuel() >= 50){
                fl0at();
            }
            else{
                System.out.println("Fuel is not enough.");
            }
        }
    }
    public void fl0at(){
        if (super.getFuel() >= 50){
            System.out.println("Ship moves.");
            super.setFuel(super.getFuel()-50);
        }
        else{
            System.out.println("Fuel is not enough.");
        }
    }
    public void startEngine(){
        if (super.getFuel() >= 10){
            System.out.println("Engine starts.");
            super.setFuel(super.getFuel()-10);
        }
        else{
            System.out.println("Fuel is not enough.");
        }
    }
    public void stopEngine(){
        System.out.println("Engine stops.");
    }
    public void honk(){
        System.out.println("Shhhhh");
    }
}
