import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.*;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Patterns:\n(1) Unsigned\n(2) Sign and Magnitude\n(3) Two's Complement");
        System.out.print("Choose the pattern: ");
        int choice = sc.nextInt();
        System.out.println();

        String number = "";
        String binary = "";

        switch(choice) {
            case 1: 
                System.out.print("Positive integer: ");
                number = sc.next();
                binary = unsigned(number);
                break;
            case 2:
                System.out.print("Integer: ");
                number = sc.next();
                binary = signAndMagnitude(number);
                break;
            default:
                binary = "Not implemented yet";
                break;
        }
        
        System.out.println("Binary value: " + binary);        
        sc.close();        
    }

    public static String unsigned(String number){
        int value = Integer.parseInt(number);
        int r = 0;
        String st = "";
        while(value != 0){
            r = value % 2;
            st = r + st;
            value = value/2;
        }
        return st;
    }

    public static String signAndMagnitude(String number){
        String st = "";
        String sign = "";
        if (number.charAt(0) == '-'){
            sign = "1";
            st = unsigned(number.substring(1));
        } else {
            sign = "0";
            st = unsigned(number.substring(0));
        }
        return sign + st;
    }

    /*public static String twoComplement(String number){
        char sign = number.charAt(0);
        if (sign == '+'){
            return unsigned(number.substring(1));
        } else {
            sign = '1';
        }
        int value = Integer.parseInt(number.substring(1));
    }*/
}
