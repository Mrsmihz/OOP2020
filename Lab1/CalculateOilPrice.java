import java.util.*;
public class CalculateOilPrice {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double liter = sc.nextDouble();
        sc.close();
        System.out.println(30*liter);
    }
}
