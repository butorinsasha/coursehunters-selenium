package lesson023overloadingmethods;

public class OverloadingMethodsTest {
    public static void main(String[] args) {
        int result;
        result = getSum(1, 10);
        System.out.println(result);

        result = getSum(5, 100, 66);
        System.out.println(result);

        System.out.println();

        sayHello();
        sayHello("Linus");
        sayHello("Torvalds", "Git");

        System.out.println();

        int[] intarr = {1, 22, 52, 34, 16};
        int sum = getSum(intarr, "Stew");
        System.out.println(sum + 100);
    }


    static int getSum(int x, int y) {
        int sum;
        sum = x + y;
        return sum;
    }

    static int getSum(int x, int y, int z) {
            int sum;
            sum = x + y + z;
            return sum;
    }

    static int getSum(int[] arr, String n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sayHello(n);
        System.out.println("sum = " + sum);
        return sum;
    }

    static void sayHello() {
        System.out.println("Hello");
    }

    static void  sayHello(String name) {
        System.out.println("Hello, " + name);
        System.out.println("Got some money?");
    }

    static void  sayHello(String name1, String name2) {
        System.out.println("Hello, " + name1);
        System.out.println("Hello, " + name2);
        System.out.println("Got some money?");
    }

}
