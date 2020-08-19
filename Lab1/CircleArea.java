import java.util.*;

public class CircleArea {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Radius = ");
    double radius = sc.nextDouble();
    sc.close();
    double area;
    area = Math.PI*Math.pow(radius, 2);
    System.out.println(area);
    }
}
