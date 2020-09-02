public class Main {
    public static void main(String[] args) {
        third();
    }
    public static void first(){
        Plane p1 = new Plane();
        p1.setPlaneInfo(500, "High");
        p1.showPlaneInfo();
        Car c1 = new Car();
        c1.setCarInfo(500, "High", "Diesel");
        c1.showCarInfo();
    }
    public static void second(){
        Plane p1 = new Plane();
        p1.setPlaneInfo(300, "High");
        p1.showPlaneInfo();
        p1.Fly();
        p1.showPlaneInfo();
        p1.Fly();
        p1.showPlaneInfo();
    }
    public static void third(){
        Car c1 = new Car();
        c1.setCarInfo(60, "High", "Diesel");
        c1.showCarInfo();
        c1.Move();
        c1.showCarInfo();
        c1.Move();
        c1.showCarInfo();
    }
}
