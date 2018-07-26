package lesson031abstractclasses;

public class Cat extends Animal {

    @Override
    public void saySmth() {
        System.out.println("Mew mew mew");
    }

    @Override
    public void eat() {
        System.out.println("I like eat");
    }
}
