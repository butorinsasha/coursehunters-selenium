package lesson031abstractclasses;

public class Dog extends Animal {
    @Override
    public void saySmth() {
        System.out.println("Gav gav gav");
    }

    @Override
    public void eat() {
        System.out.println("I like my food. Got more?");
    }

    public void sit() {
        System.out.println("I'm sitting");
    }
}
