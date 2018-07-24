package mypackage;


public class TestClass {

    public static void main(String[] args) {

       int a = 13;
       int b = 3;
       int sum;

       sum = getSum(a, b);
        System.out.println(sum);
        sum = getSum(10, 150);
        System.out.println(sum);
        System.out.println(getSum(2, 11));

        showSum(10, 51, 77);
        showSum(5, 12, 14);

        saySmth();
        saySmth();
        saySmth();

        sayHello("Petya");
        String name = "Vasya";
        sayHello(name);

        showSumToPerson("Vanya", 15, 11, 33);

        boolean result = showSum(1 , 22, 333);
        System.out.println(result);

    }

    static int getSum(int x, int y){
        int sum;
        sum = x + y;
        return sum;
    }

    static boolean showSum(int x, int y, int z){
        int sum = x + y + z;
        System.out.println("Sum is: " + sum);
        return true;
    }

    static void saySmth(){
        System.out.println();
        System.out.println("Hello!");
        System.out.println("I'm running!");
        System.out.println("You see me!");
    }

    static void sayHello(String name){
        System.out.println();
        System.out.println("Hello " + name +"!");
        System.out.println("I'm your program!");
        System.out.println("Nice to meet you!");
    }

    static void showSumToPerson(String name, int a, int b, int c){
        System.out.println("Start of program!");
        sayHello(name);
        showSum(a, b, c);
        System.out.println("End of program!");
    }
}
