package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExceptionTask3 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList();
        myList.add("h");
        myList.add("hg");
        myList.add("hg");

        try{
            System.out.println(myList.get(10));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e);
        }

    }
}
