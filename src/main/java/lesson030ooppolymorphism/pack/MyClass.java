package lesson030ooppolymorphism.pack;

import lesson030ooppolymorphism.zoo.Animal;
import lesson030ooppolymorphism.zoo.Dog;

public class MyClass extends Animal{
    void method() {
        Dog dog = new Dog();
        dog.publicVar = 10;
//        dog.privateVar = 10;
        protectedVar = 30;
//        defaultVar = 40; // defaultVar has package-private modifier in class Animal and can'n be accessed outside the same package

    }
}
