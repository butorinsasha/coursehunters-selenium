package lesson020set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main (String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(11);
        set.add(9);
        set.add(11);

        System.out.println("set.size() = "+set.size());
        System.out.println();

        set.remove(11);

        /*No get() in class Set*/
//        set.get()

        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

//        set.clear();
        System.out.println("set.size() = "+set.size());

        System.out.println();

        System.out.println(set.contains(10));
        System.out.println(set.contains(11));

        System.out.println();

        for (int i: set) {
            System.out.println(i);
        }
    }
}
