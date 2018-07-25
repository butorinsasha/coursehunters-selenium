package lesson018list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void printList(List<Integer> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.println(i + " " + l.get(i));
        }
    }

    public static void main(String[] args) {

        /*1. Create List variable with ArrayList implementation*/
        System.out.println("*** 1. Create List variable with ArrayList implementation ***");
        List<Integer> list1 = new ArrayList<>();

        /*2. Adding elements to the list1*/
        System.out.println("*** 2. Adding elements to the list1 ***");
        list1.add(1);
        list1.add(2);
        list1.add(12);
        printList(list1);
        System.out.println();

        /*3. Set the element at the specific position at list1*/
        System.out.println("*** 3. Set the element at the specific position at list1 ***");
        list1.set(2, 100); // value at index of 2 is overwritten
        printList(list1);
        System.out.println();

        /*4. Removing the element at specific index at list1*/
        System.out.println("*** 4. Removeing the element at specific index at list1 ***");
//        list1.remove(1);
        list1.remove(new Integer(1));
        printList(list1);
        System.out.println();

        /*5. Getting list1 size*/
        System.out.println("*** 5. Getting list1 size ***");
        printList(list1);
        System.out.println("*** list1.size() = " + list1.size());
        System.out.println();


        /*6. Clearing the list1*/
//        System.out.println("6. Cleaing the list1 ***");
//        list1.clear();
//        System.out.println("list1.size() = " + list1.size());
//        printList(list1);
//        System.out.println();

        /*7. Creating list2*/
        System.out.println("*** 7. Creating list2 ***");
        List<Integer> list2 = new ArrayList<>();

        /*8. Adding two elements into the second list2*/
        System.out.println("8. Adding two elements into the list2 ***");
        list2.add(45);
        list2.add(56);
        printList(list2);
        System.out.println("list2.size() = " + list2.size());
        System.out.println();

        /*9. Adding all elemets from list2 into list1*/
        System.out.println("*** 9. Adding all elemets from list2 into list1 ***");
        list1.addAll(list2);
        printList(list1);
        System.out.println("list1.size() = " + list1.size());
        System.out.println();

        /*10. Removing all elements of list2 from list1*/
        System.out.println("*** 10. Removing all elements of llist2 from list1 ***");
        list1.removeAll(list2);
        printList(list1);
        System.out.println("list1.size() = " + list1.size());
        System.out.println();

        /*11. Checking whether list1 is empty or not*/
//        System.out.println("*** 11. Checking whether list1 is empty or not ***");
//        System.out.println("list1.isEmpty() = " + list1.isEmpty());
//        list1.clear();
//        System.out.println("list1.isEmpty() = " + list1.isEmpty());

        /*12. Cheking whether the list contains an element*/
        System.out.println("*** 12. Cheking whether the list contains an element ***");
        printList(list1);
        System.out.println("list1.contains(100) = " + list1.contains(100));
        System.out.println("list1.contains(987) = " + list1.contains(987));
        System.out.println();

        /*13. Checing whether the list contains all elements from another list*/
        System.out.println("*** 13.Checing whether the list contains all elements from another list ***");
        list1.addAll(list2);
        printList(list1);
        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));
        list1.set(3, 55);
//        list1.remove(list1.size()-1);
        list1.removeAll(list2);
        printList(list1);
        System.out.println("list1.containsAll(list2) = " + list1.containsAll(list2));
    }
}
