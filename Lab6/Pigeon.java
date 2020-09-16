public class Pigeon extends Bird{
    private static int numberOfPigeon;
    public Pigeon(){
        this(0,0,0);
    }
    public Pigeon(double wingSize, double weight, double height){
        super(wingSize, weight, height);
        numberOfPigeon++;
    }
    public void eat(String food){
        if (food.equals("worm")){
            super.setWeight(super.getWeight()+0.5);
        }
        else if (food.equals("seed")){
            super.setWeight(super.getWeight()+0.2);
        }
        else{
            System.out.println("Pigeon can eat only worm and seed.");
        }
    }
    public String toString(){
        return String.format("Pigeon %.2f and %.2f cm. There are %d pigeons.", super.getWeight(), super.getHeight(), numberOfPigeon);
    }
    public void fly(){
        super.setWeight(super.getWeight()-0.25);
        if (super.getWeight() >= 5){
            System.out.println("Fly Fly");
        }
        else{
            System.out.println("I'm hungry.");
        }
    }
    public void takeOff(){
        super.setWeight(super.getWeight()-0.5);
        if (super.getWeight() >= 5){
            System.out.println("Take Off");
        }
        else{
            System.out.println("I'm hungry.");
        }
    }
    public void landing(){
        super.setWeight(super.getWeight()-0.5);
        if (super.getWeight() >= 5){
            System.out.println("Landing");
        }
        else{
            System.out.println("I'm hungry.");
        }
    }
}
