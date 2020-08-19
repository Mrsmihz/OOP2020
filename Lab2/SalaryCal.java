import java.util.*;

public class SalaryCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int age, working_days, absent_days;
        double weight, salary, bonus;
        System.out.print("Please insert your name : ");
        name = sc.next();
        System.out.print("Please insert your age : ");
        age = sc.nextInt();
        System.out.print("Please insert number of working days : ");
        working_days = sc.nextInt();
        System.out.print("Please insert number of absent days : ");
        absent_days = sc.nextInt();
        System.out.print("Please insert your body weight : ");
        weight = sc.nextDouble();
        sc.close();
        salary = calsalary(age, working_days, absent_days);
        bonus = calbonus(weight);
        System.out.println("Hi, "+name);
        System.out.printf("Your salary is %.2f Baht\n", salary);
        System.out.printf("Your salary and bonus is %.2f Baht\n", salary + bonus);
    }
    private static double calsalary(int age, int working_days, int absent_days){
        double salary = 0;
        if (age > 20 && age <= 30){
            salary = (working_days * 300) - (absent_days * 50);
        }
        else if (age > 30 && age <= 40){
            salary = (working_days * 500) - (absent_days * 50);
        }
        else if (age > 40 && age <= 50){
            salary = (working_days * 1000) - (absent_days * 25);
        }
        else if (age > 50 && age <= 60){
            salary = (working_days * 3000);
        }
        return salary;
    }
    private static double calbonus(double weight){
        double bonus = 0;
        if (weight >= 10 && weight <= 60){
            bonus += 5000;
        }
        else if (weight > 60 && weight <= 90){
            bonus += (5000 - (weight-60)*10);
        }
        return bonus;
    }
}
