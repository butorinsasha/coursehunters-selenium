package lesson032interfaces;

public class Plane implements Transport, Flyable {

    int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
        System.out.println("Plane's speed is set to " + speed);
    }

    @Override
    public void go() {
        System.out.println("Plane is flying");
    }

    @Override
    public void stop() {
        System.out.println("Plane has landed");
    }


    @Override
    public void onlyFlyersCanDo1() {
        System.out.println("Do what only flayers can do1");

    }

    @Override
    public void onlyFlyersCanDo2() {
        System.out.println("Do what only flayers can do2");

    }
}
