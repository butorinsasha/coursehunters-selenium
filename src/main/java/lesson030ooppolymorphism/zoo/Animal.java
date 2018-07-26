package lesson030ooppolymorphism.zoo;

public class Animal {
    protected String name;
    protected String color;

    public int publicVar;       // "public" means "is accessed everywhere"
    private int privateVar;     // "private" means "is accessed only inside the class"
    protected int protectedVar; // "protected" means "is accessed only inside the class, for classes inside the same package and for subclasses"
    int defaultVar;             // "package-private" = "default" means "is accessed only inside he same package

    public void walk(String place) {
        System.out.println("We are walking here: " + place);
        publicVar = 10;
        privateVar = 20;
    }

    public void sleep() {
        System.out.println("Zzzz");
    }

    public void sound() {
        System.out.println("Hello");
    }
}

