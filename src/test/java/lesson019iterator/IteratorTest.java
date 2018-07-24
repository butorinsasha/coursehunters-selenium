package lesson019iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(17);
        list.add(23);
        list.add(37);
        list.add(47);

        Iterator<Integer> iterator = list.iterator(); // * after creation points before the first element

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

//        System.out.println("iterator.hasNext() = " + iterator.hasNext()); // *
//        System.out.println(iterator.next()); // prints an element the iterator points at (next one) and moves iterator to this element)
//        System.out.println("iterator.hasNext() = " + iterator.hasNext());
//        System.out.println(iterator.next());
//        System.out.println("iterator.hasNext() = " + iterator.hasNext());
//        System.out.println(iterator.next());
//        System.out.println("iterator.hasNext() = " + iterator.hasNext());
//        System.out.println(iterator.next());
//        System.out.println("iterator.hasNext() = " + iterator.hasNext());
    }
}
