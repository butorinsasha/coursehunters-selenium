package lesson016conditions;

public class ConditionsTest {

    public static void main(String[] args) {

        int i = 10;

        System.out.println("Start");

        if (i > 10) {
            System.out.println("i > 10");
            i++;
            System.out.println(i);
        } else if (i > 5  && i < 10){
            System.out.println("i > 5  && i < 10");
            i--;
            System.out.println(i);
        } else {
            System.out.println("Nothing");
        }

        System.out.println("End");
        System.out.println();

        i = 40;
        if (i > 50 ) {
            System.out.println("i > 50");
            if (i > 90) {
                System.out.println("i > 90");
            } else {
                System.out.println("i <= 90");
            }
        }
        else {
            System.out.println("i <= 50");
        }
        System.out.println();

        i=2;
        switch (i) {
            case 1:
                System.out.println("i=1");
                break;
            case 2:
                System.out.println("i=2");
                break;
            case 3:
                System.out.println("i=3");
                break;
            default:
                System.out.println("default case");
//                break;
        }


    }

}
