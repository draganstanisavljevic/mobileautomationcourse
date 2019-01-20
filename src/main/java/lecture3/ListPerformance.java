package lecture3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListPerformance {

    static List<String> arrayList = new ArrayList<String>();
    static List<String> linkedList = new LinkedList<String>();

    public static void main(String[] args) {
        meassureAddingToArrayList(arrayList);
        meassureAddingToArrayList(linkedList);
        meassureGettingFromArrayList(arrayList);
        meassureGettingFromArrayList(linkedList);
        meassureDeletingFromArrayList(arrayList);
        meassureDeletingFromArrayList(linkedList);
    }

    private static void meassureAddingToArrayList(List<String> arrayList){
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 10000 ; i++) {
            arrayList.add("Element"+i);
        }
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("Time for adding = " + time);
    }

    private static void meassureGettingFromArrayList(List<String> arrayList){
        long startArray = System.currentTimeMillis();
        for (int i = 1; i <= 10000 ; i++) {
            arrayList.get(i-1);
        }
        long endArray = System.currentTimeMillis();
        long time = endArray - startArray;

        System.out.println("Time for getting list = " + time);
    }

    private static void meassureDeletingFromArrayList(List<String> list){
        long start = System.currentTimeMillis();
        for (int i = 10000; i > 0; i--) {
            list.remove(i-1);
        }
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("Time for deleting list = " + time);
    }
}
