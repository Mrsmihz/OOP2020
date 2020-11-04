import java.util.*;

public class test{
    public static void main(String[] args){
        System.out.println(quiz3(4));
    }
    public static void quiz2(int n){
        if (n == 8){
            System.out.println("Go back!");
        }
        else{
            System.out.println(n+" Hello");
            quiz2(n+2);
            System.out.println(n+" Bye");
        }
    }
    public static int quiz1(int n){
        int r1;
        if (n==1){
            r1 = 12;
        }
        else{
            r1 = n+quiz1(n/2);
            System.out.println(r1);
        }
        return r1;
    }
    public static int quiz3(int x){
        if (x<5){
            return 3*x;
        }
        else{
            return 2*quiz3(x-5)+7;
        }
    }
}
