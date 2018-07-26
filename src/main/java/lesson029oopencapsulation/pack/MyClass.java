package lesson029oopencapsulation.pack;

import lesson029oopencapsulation.zoo.Animal;
import lesson029oopencapsulation.zoo.Dog;

public class MyClass extends Animal{
    void method() {
        Dog dog = new Dog();
        dog.publicVar = 10;
//        dog.privateVar = 10;
        protectedVar = 30;
//        defaultVar = 40; // defaultVar has package-private modifier in class Animal and can'n be accessed outside the same package

    }
}
