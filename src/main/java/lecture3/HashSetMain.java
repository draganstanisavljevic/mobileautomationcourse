package lecture3;

import java.util.HashSet;

public class HashSetMain {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("женьшень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

        for (String s : set) {
            System.out.println(s);
        }
    }
}











