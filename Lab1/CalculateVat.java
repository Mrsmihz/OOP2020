import java.util.*;

public class CalculateVat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        sc.close();
        System.out.println(price * 1.07);
    }
}
