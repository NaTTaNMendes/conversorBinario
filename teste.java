import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Patterns:\n(1) Unsigned\n(2) Sign and Magnitude\n(3) Two's Complement");
        System.out.print("Choose the pattern: ");
        int choice = sc.nextInt();
        System.out.println();

        int number = 0;
        String binary = "";

        switch(choice) {
            case 1: 
                System.out.print("Positive integer: ");
                number = sc.nextInt();
                binary = unsigned(number);
                break;
            case 2:
                System.out.print("Integer: ");
                number = sc.nextInt();
                binary = signAndMagnitude(number);
                break;
            case 3:
                System.out.print("Integer: ");
                number = sc.nextInt();
                binary = twoComplement(number);
                break;
            default:
                break;
        }
        
        System.out.println("Binary value: " + binary);        
        sc.close();        
    }

    public static String unsigned(Integer number){
        int r = 0;
        String st = "";
        while(number != 0){
            r = number % 2;
            st = r + st;
            number = number / 2;
        }
        return st;
    }

    public static String signAndMagnitude(Integer number){
        String st = "";
        String sign = "";
        if (number < 0){
            sign = "1";
            st = unsigned(number * -1);
        } else {
            sign = "0";
            st = unsigned(number);
        }
        return sign + st;
    }

    public static String twoComplement(Integer number){
        String st = "";
        String begin = "";
        String end = "";
        if (number < 0){
            st = unsigned(number * -1);
            for(int i = st.length() - 1; i >= 0; i--){
                if (st.charAt(i) == '1'){
                    end = st.substring(i, st.length());
                    break;
                }
            }
            for(int i = st.length() - 1; i >= 0; i--){
                if (st.charAt(i) == '1'){
                    begin = begin + "0";
                } else {
                    begin = begin + "1";
                }
            }
            return begin + end;
        } else {
            st = unsigned(number);
            return st;
        }        
    }
}
