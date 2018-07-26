package lesson027staticandfinalmodifiers;

public class Car {

    /*Static variable belongs to the class itself and is sole for the every object of this class and can be gotten without instantiating*/
    /*Final variable cannot be overridden*/
    final static int staticVar = 10;

    /*Static method belongs to the class itself and can be invoked without instantiating*/
    /*fianal method cannot be overridden*/
    final static void staticMethod() {
        System.out.println("This is staticMethod");
    }

    int height;
    int width;
    int length;
    int weight = 2000;
    int maxWeight = 2700;
    String color;
    int speed;
    int maxSpeed = 26;

    public Car() {
        System.out.println("New car created");
    }

    public Car(String color) {
        this.color = color;
        System.out.println("New " + color + " car created");
    }

    public void addWeight(int weight) {
        this.weight += weight;
        System.out.println("New weight = " +this.weight);
    }

    public void drive(int speed) {
        if (weight <= maxWeight) {
            this.speed = speed;
            System.out.println("Driving. speed = " + speed);
        } else {
            System.out.println("Not Driving. weight = " + weight + ". Too much load. Cant drive. maxWeight = 2700. Degrease load!");
        }
    }
}
