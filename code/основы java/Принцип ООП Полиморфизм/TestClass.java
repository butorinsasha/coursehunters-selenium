package mypackage;


public class TestClass {

    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();

        cat.name = "Vasya";
        dog.name = "Barsik";

        cat.color = "White";
        dog.color = "Black";

        cat.walk("Backyard");
        dog.walk("Park");

        cat.feed("Milk");
        dog.sit();

        System.out.println("Cat name is: " + cat.name);
        System.out.println("Dog name is: " + dog.name);

        dog.sound();
        cat.sound();

    }

}
