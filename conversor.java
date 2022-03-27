import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.floor;

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
        }
        
        System.out.println("Binary value: " + binary);        
        sc.close();        
    }

    public static String unsigned(String number){
        int value = Integer.parseInt(number);
        if (value == 0){
            return "0";
        }
        if (value == 1){
            return "1";
        }
        List<String> numbers = new ArrayList<>();
        boolean check = true;
        int remnant = 0;

        while(check == true){
            remnant = value % 2;
            value = (int)Math.floor(value/2);
            numbers.add(String.valueOf(remnant));
            if (value == 1){
                numbers.add("1");
                check = false;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.get(numbers.size()-1));
        for (int i = numbers.size()-1; i > 0; i--){
            sb.append(numbers.get(i-1));            
        }
        
        return sb.toString();
    }

    public static String signAndMagnitude(String number){
        String response = "";
        if (number.length() < 2) {
            response = "Error: Value not supported";
        } else {
            char sign = number.charAt(0);
        int value = Integer.parseInt(number.substring(1));
        if (sign == '+'){
            sign = '0';
        } else {
            sign = '1';
        }
        if (value == 0){
            return sign + "0";
        }
        if (value == 1){
            return sign + "1";
        }
        List<String> numbers = new ArrayList<>();
        boolean check = true;
        int remnant = 0;

        while(check == true){
            remnant = value % 2;
            value = (int)Math.floor(value/2);
            numbers.add(String.valueOf(remnant));
            if (value == 1){
                numbers.add("1");
                check = false;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(sign);
        sb.append(numbers.get(numbers.size()-1));
        for (int i = numbers.size()-1; i > 0; i--){
            sb.append(numbers.get(i-1));            
        }
        
        return sb.toString();
        }
        return response;
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

