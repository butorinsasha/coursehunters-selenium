package mypackage;

public class TestClass {

    public static void main(String[] args) {

        Car car = new Car();
        Plane plane = new Plane();

        car.go();
        car.stop();
        car.method1();
        car.method2();

        plane.go();
        plane.stop();
        plane.setSpeed(500);

    }

}
