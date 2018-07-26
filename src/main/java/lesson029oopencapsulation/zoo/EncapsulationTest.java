package lesson029oopencapsulation.zoo;

public class EncapsulationTest {
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

        dog.publicVar = 10;
//        dog.privateVar = 20;
        dog.protectedVar = 30;
        dog.defaultVar = 40;

        System.out.println();

        System.out.println(dog.getWeight());
    }
}
