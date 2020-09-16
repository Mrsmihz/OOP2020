public class Main {
    public static void main(String[] args) {
        second();
    }
    public static void first(){
        Pigeon p1 = new Pigeon(10, 15, 20);
        System.out.println(p1);
        p1.takeOff();
        System.out.println(p1);
        p1.fly();
        System.out.println(p1);
        p1.landing();
        System.out.println(p1);
        p1.eat("seed");
        System.out.println(p1);
        Pigeon p3 = new Pigeon();
        System.out.println(p3);
    }
    public static void second(){
        Plane p1 = new Plane(200, "IT Airline", "FX-747");
        Ship s1 = new Ship(200);

        System.out.println("===== Plane =====");
        p1.startEngine();
        p1.takeOff();
        p1.fly();
        p1.fly();
        p1.honk();
        p1.landing();
        p1.stopEngine();

        System.out.println("===== Ship =====");
        s1.startEngine();
        s1.move(2);
        s1.honk();
        s1.stopEngine();
    }
}
