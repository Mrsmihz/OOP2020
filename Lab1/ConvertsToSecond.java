import java.util.*;

public class ConvertsToSecond{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        int mins = sc.nextInt();
        sc.close();
        int second = hours * 3600 + mins * 60;
        System.out.println("Secs = " + second);
    }
}
