package playground;

import java.util.Arrays;
import java.util.Random;

public class Coin {

    public static boolean[] throwCoin(int times) {
        Random generate = new Random();
        boolean[] results = new boolean[times];
        for (int i = 0; i < times; i++) {
            boolean result = generate.nextBoolean();
            System.out.println(result);
            results[i] = result;
        }
        return results;
    }

    public static void main(String[] args) {
//        throwCoin(5); // Can be invoked not-void method without assigning the result to some variable
        boolean[] coinThrows = throwCoin(6);
        System.out.println();
        for (boolean coinThrow : coinThrows) {
            System.out.println(coinThrow);
        }
    }
}
