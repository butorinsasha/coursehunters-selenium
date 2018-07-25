package lesson26constuctors;

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
   }
}