package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListsTask1 {

    public static void main(String[] args) {
        List<String> elements = new ArrayList();
        addElement(elements);
        int indexFirst = 0;
        boolean found = false;
        for (int i = 1; i < 10; i++) {
            addElement(elements);
            if(elements.get(i).length() < elements.get(i-1).length()){
                if(!found){
                    indexFirst = i;
                    found = true;
                }

            }
        }

        if(found){
            System.out.println("Index of first not ordered element = " + indexFirst);
        }
    }

    private static void addElement(List<String> elements){
        Scanner scan = new Scanner(System.in);
        String myWord = scan.nextLine();
        elements.add(myWord);
    }
}
