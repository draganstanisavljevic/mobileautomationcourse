package lecture3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CatMain {

    private static HashMap<String, Cat> cats;

    public static void main(String[] args) {
        cats = new HashMap();
        addCats(cats);
        printCats(cats);
    }

    private static HashMap<String, Cat>  addCats(HashMap<String, Cat> cats){
        String name;
        for (int i = 1; i <= 10; i++) {
            name = "Cat"+i;
            cats.put(name, new Cat(name));
        }

        return cats;
    }

    private static void printCats(HashMap<String, Cat> cats){
        Iterator<Map.Entry<String, Cat>> iterator = cats.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cat> pair = iterator.next();
            System.out.println("Key: " + pair.getKey() + "; Cat name: " + pair.getValue().getName());
        }
    }
}
