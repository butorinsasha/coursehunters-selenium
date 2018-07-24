package mypackage;


public class TestClass {

    public static void main(String[] args) {

        int result;

        result = getSum(1, 10);
        System.out.println(result);
        result = getSum(5, 100, 66);
        System.out.println(result);

        sayHello("Petya");
        sayHello("Vasya", "Vanya");
        sayHello();

        int[] array = {1, 22, 52, 34, 16};

        int sum = getSum(array, "Oleg");
        System.out.println(sum + 100);

    }

    static int getSum(int x, int y){
        int sum;
        sum = x + y;
        return sum;
    }

    static int getSum(int x, int y, int z){
        int sum;
        sum = x + y + z;
        return sum;
    }

    static int getSum(int[] array, String name){
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.println("Hi " + name + "!");
        System.out.println("Your sum is: " + sum);
        return sum;
    }


    static void sayHello(String name){
        System.out.println();
        System.out.println("Hello " + name +"!");
        System.out.println("I'm your program!");
        System.out.println("Nice to meet you!");
    }

    static void sayHello(String name1, String name2){
        System.out.println();
        System.out.println("Hello " + name1 +"!");
        System.out.println("Hello " + name2 +"!");
        System.out.println("I'm your program!");
        System.out.println("Nice to meet you!");
    }

    static void sayHello(){
        System.out.println();
        System.out.println("Hello");
        System.out.println("I'm your program!");
        System.out.println("Nice to meet you!");
    }

}
