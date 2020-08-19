import java.util.*;
public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double deposit = sc.nextDouble();
        char account_type = sc.next().charAt(0);
        sc.close();
        switch (account_type)
        {
            case 'A':
                deposit *= 1.015;
                break;
            case 'B':
                deposit *= 1.020;
                break;
            case 'C':
                deposit *= 1.015;
                break;
            case 'X':
                deposit *= 1.050;
                break;
        }
        System.out.printf("Total money = %.2f\n", deposit);
    }
}
