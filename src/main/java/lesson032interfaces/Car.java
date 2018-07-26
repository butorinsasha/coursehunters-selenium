package lesson032interfaces;

public class Car implements Transport, Wheeled{

    @Override
    public void go() {
        System.out.println("Car is driving");
    }

    @Override
    public void stop() {
        System.out.println("Car has stopped");
    }

    @Override
    public void onlyWheelersCanDo1() {
        System.out.println("Do what only wheelers can do1");
    }

    @Override
    public void onlyWheelersCanDo2() {
        System.out.println("Do what only wheelers can do2");
    }

    public void testInterfaceVar() {
        System.out.println(interfaceVar);
    }
}
