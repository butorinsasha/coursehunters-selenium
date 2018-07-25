package lesson021map;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MapTest {
    public static void main (String[] args) {

        Map<Integer, String> map = new HashMap<>();

        map.put(1, "black");
        map.put(2, "white");
        map.put(3, "yellow");
        map.put(10, "green");

        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.get(1));
        System.out.println(map.get(10));


        System.out.println("map.size() = " + map.size());;
//        map.clear();
        System.out.println("map.size() = " + map.size());;

        System.out.println();

        System.out.println("map.containsKey(90) = " + map.containsKey(90));
        System.out.println("map.containsKey(10) = " + map.containsKey(10));
        System.out.println("map.containsValue(\"grey\") = " + map.containsValue("grey"));
        System.out.println("map.containsValue(\"white\") = " + map.containsValue("white"));

        System.out.println();

        Set<Integer> keys = map.keySet(); // keySet returns Set of keys
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        map.put(2, "yellow");
        System.out.println(map.get(2));

        Map<String, String> map2 = new HashMap<>();
        map2.put("postCode", "123456");
        map2.put("inn", "1234567890");
        System.out.println(map2.get("inn"));
    }
}
