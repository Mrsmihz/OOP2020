import java.util.*;
public class PrintEqual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.close();
        System.out.print(x);
        for (int i = 0;i<x;i++){
            System.out.print("=");
        }
        System.out.print("+");
    }
}
