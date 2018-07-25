package lesson015string;

public class StringTest {
    public static void main(String[] args){
        String s = "Hello";
        System.out.println(s.equals("Hello World"));
        System.out.println(s.equals("Hello"));
        System.out.println(s=="Hello World"); // hmm true
        System.out.println(s==new String("Hello World")); // that is false
        System.out.println();

        String s1 = "hello";
        System.out.println(s.equals(s1));
        System.out.println(s.equalsIgnoreCase(s1));
        System.out.println();

        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println();

        System.out.println(s.charAt(1));
        System.out.println(s.indexOf("el"));
        System.out.println();

        System.out.println(s.contains("lo"));
        System.out.println();

        System.out.println(s.length());
        System.out.println();

        System.out.println(s.endsWith("llo"));
        System.out.println(s.startsWith("Hel"));
        System.out.println();

        String str = "hello,world";
        System.out.println("str = \"" + str + "\"");
        String[] strArr = str.split(",");
        for (String a: strArr) {
            System.out.println(a);
        }

        String fstr = "My name is %s! I'm %d years old!";
        System.out.println(fstr);
        int age = 30;
        String name = "Ivan";
        System.out.println(String.format(fstr, name, age));
        System.out.println(String.format(fstr, "Vasya", 10));
        System.out.println();

        String age2 = "30";
        int a = Integer.parseInt(age2);
        System.out.println(a * 3);
        System.out.println();

        System.out.println(s.substring(1,5));
        System.out.println(s.substring(3));

        System.out.println(s.substring(0, s.length()));

        String s2 = "Happy";
        String s3 = "New";
        String s4 = "Year";
        String res = s2 + " " + s3 + " " + s4 + "!";
        System.out.println(res);
        res = s2.concat(s3).concat(s3).concat(s4); // is better than "+" in terms of efficiency when the project is big enough
        System.out.println(res);

    };
}
