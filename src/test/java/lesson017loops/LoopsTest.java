package lesson017loops;

public class LoopsTest {

    public static void main(String[] args) {

        System.out.println("Start");

        for (int i = 0; i < 10; i++) {
            System.out.println(i * 10);
        }

        System.out.println("End");
        System.out.println();

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
        System.out.println();

        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i * 2;
        }

        for (int i = 0 ; i < 10; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
        System.out.println();
        for (int e: array) {
            System.out.println(e);
        }
        System.out.println();
        System.out.println();

        int i = 0;
        boolean bool = true;
        while (bool) {
            System.out.println("while: " + i);
            i++;
            if (i == 5 ) bool = false;
        }
        System.out.println();
        System.out.println();

        i = 4;
        do {
            System.out.println("do while: " + i);
            i++;
        } while (i < 5);
    }

}
