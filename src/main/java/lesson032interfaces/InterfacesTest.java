package lesson032interfaces;

public class InterfacesTest {

    public static void main(String[] args) {
        Car car = new Car();
        Plane plane = new Plane();

        car.go();
        car.stop();

        plane.go();
        plane.stop();
        plane.setSpeed(500);

        car.onlyWheelersCanDo1();
        car.onlyWheelersCanDo2();

        plane.onlyFlyersCanDo1();
        plane.onlyFlyersCanDo2();

        System.out.println(car.interfaceVar);
        System.out.println(Transport.interfaceVar);

    }

}
