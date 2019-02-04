package exceptions;

import java.util.Scanner;

public class ExceptionTask2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        try{
            int num = Integer.parseInt(number);
            System.out.println(num);
        }catch(NumberFormatException e){
            System.out.println(e);
        }

    }
}
