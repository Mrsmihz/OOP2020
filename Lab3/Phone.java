public class Phone {
    private String brandName = new String();
    private boolean hasFM;
    private boolean hasCamera;
    private double price;
    private int space;
    public void call(String n){
        System.out.println("Calling to "+n);
    }
    public void turnOn(){
        System.out.println("On");
    }
    public void turnOff(){
        System.out.println("Off");
    }
}
