public abstract class Vehicle implements Dieselable{
    protected double fuel;
    public Vehicle(){
        this(0);
    }
    public Vehicle(double fuel){
        this.fuel = fuel;
    }
    public void addFuel(double fuel){
        if (fuel > 0){
            this.fuel += fuel;
        }
        else{
            System.out.println("Fuel is empty.");
        }
    }
    public abstract void honk();

    public void setFuel(double f){
        this.fuel = f;
    }
    public double getFuel(){
        return this.fuel;
    }
}
