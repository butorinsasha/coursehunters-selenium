package lesson031abstractclasses;

public abstract class Animal { //

    public abstract void saySmth(); // abstract method has to be only declared, no implementation needed
    public abstract void eat();

    public void walk(String place) {
        System.out.println("I'm wlking here: " + place);
    }
}
