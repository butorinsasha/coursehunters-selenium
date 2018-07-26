package lesson027staticandfinalmodifiers;

public class CarTest {
    public static void main(String[] args) {

        Car car1 = new Car();
        car1.color = "black";
        car1.length = 5000;
        car1.height = 2000;
        car1.width = 2000;

        car1.addWeight(500);
        car1.drive(100);
        System.out.println();

        car1.addWeight(500);
        car1.drive(100);
        System.out.println();

        car1.addWeight(-500);
        car1.drive(300);
        System.out.println();

        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car("green");

        System.out.println("Car.staticVar = " + Car.staticVar);
//        Car.staticVar = 100;
        System.out.println("car1.staticVar = " + car1.staticVar);
        System.out.println("car2.staticVar = " + car2.staticVar);
        System.out.println("car3.staticVar = " + car3.staticVar);
        System.out.println();

        Car.staticMethod();
        car1.staticMethod();
        car2.staticMethod();
        car3.staticMethod();
        System.out.println();

        String.format("New %s string", "super"); // format() is a static method
        Math.sqrt(4);   // sqrt() - is a static method
   }
}