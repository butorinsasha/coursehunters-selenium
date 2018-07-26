package lesson030ooppolymorphism.zoo;

public class Dog extends Animal {

    private int weight = 2;

    private int noGetNoSetVar;

    public int getWeight() {
        return weight;
    }

//    public void setWeight(int weight) {
//        this.weight = weight;
//    }

    public void sit() {
        System.out.println("I'm sitting");
        publicVar = 10;
//        privateVar = 20;
        protectedVar = 30;
        defaultVar = 40;
    }

    public void lay() {
        System.out.println("I'm laying");
    }
}
