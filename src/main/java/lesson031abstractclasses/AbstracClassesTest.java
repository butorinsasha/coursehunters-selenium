package lesson031abstractclasses;

public class AbstracClassesTest {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.walk("park");
        dog.saySmth();
        dog.eat();

        cat.walk("backyard");
        cat.eat();
    }
}
