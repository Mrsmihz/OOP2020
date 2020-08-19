import java.util.*;

public class TaxCalculate {
    public static void main(String[] args) {
        double salary;
        Scanner sc = new Scanner(System.in);
        salary = sc.nextDouble();
        sc.close();
        if (salary > 50000){
            salary *= 0.9;
        }
        else{
            salary *= 0.95;
        }
        System.out.println(salary);
    }
}
