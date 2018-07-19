package lesson012datatypes;

public class Types {
    public static void main(String[] args) {
        byte b = 5; // -128..127
        short sh = -100;
        int i = 100000;
        long l = -213573834;
        System.out.println("byte b = " + b);
        System.out.println("short sh = " + sh);
        System.out.println("ind i = " + i);
        System.out.println("long l = " + l);

        System.out.print("\n");

        double d = 3.1415;
        System.out.println("double d = " + d);
        float f = 2.71928f;
        System.out.println("float f = " + f);

        System.out.print("\n");

        boolean boo1 = true;
        boolean boo2 = false;
        System.out.println("boo1 = " + boo1);
        System.out.println("boo2 = " + boo2);
        boolean boo3 = 1+2 > 0;
        boolean boo4 = 1+2 > 5;
        System.out.println("boo3 = " + boo3);
        System.out.println("boo4 = " + boo4);

        System.out.print("\n");

        String str1 = "Hello";
        String str2 = "World!";
        String str3 = str1 + " " + str2;
        System.out.println("str3 = " + str3);

        System.out.print("\n");

        char ch = 'q';
        System.out.println("ch = " + ch);

    }
}
