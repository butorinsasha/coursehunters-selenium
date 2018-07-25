package lesson022methods;

public class MethodsTest {
    public static void main(String[] args) {
        int a = 13;
        int b = 3;
        int sum;
        sum = getSum(a, b);
        System.out.println(sum);
        System.out.println(getSum(2, 11));

        showSum(10, 51, 77);
        showSum(5, 12, 14);

        saySmth();
        saySmth();
        saySmth();

        sayHello("bro");
        String gst = "guest";
        sayHello(gst);
        showSumToPerson("sasha", 15, 11, 33);

        boolean result = showSum(1, 22, 333);
        System.out.println(result);
    }

    static int getSum(int x, int y) {
        int sum;
        sum = x + y;
        return sum;
    }

    static boolean showSum(int x, int y, int z) {
        int sum = x + y +z;
        System.out.println("Sum is: " + sum);
        return true;
    }

    static void saySmth() {
        System.out.println("Something is said");
    }

    static void  sayHello(String name) {
        System.out.println("Hello, " + name);
        System.out.println("Got some money?");
    }

    static void showSumToPerson(String name, int a, int b, int c) {
        System.out.println("*** START showSumToPerson() method***");
        sayHello(name);
        showSum(a, b, c);
        System.out.println("*** END showSumToPerson() method***");
    }

}
