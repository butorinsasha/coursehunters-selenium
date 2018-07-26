package lesson026constuctors;

public class Car {
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
