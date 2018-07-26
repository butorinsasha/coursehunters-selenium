package lesson028oopinheritance;

public class InheritanceTest {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        dog.name = "Druzhok";
        cat.name = "Barsik";

        cat.color = "White";
        dog.color = "Black";

        cat.walk("bakyard");
        dog.walk("park");

        cat.feed("milk");
        dog.sit();
        dog.lay();

        System.out.println("Cat name is " + cat.name);
        System.out.println("Dog name is " + dog.name);
    }
}
