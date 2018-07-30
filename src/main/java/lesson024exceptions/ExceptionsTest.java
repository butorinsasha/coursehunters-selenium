package lesson024exceptions;

public class ExceptionsTest {

    public static void main(String[] args) {

//        divideNoExceptionHandling(10, 0);
//        divideWithExceptionHandling(10, 0);

//        divideWithUncheckedExceptionThrown(10, 0);

//        try {
//            divideWithUncheckedExceptionNotThrown(10, 0);
//        } catch (ArithmeticException e) {
//            System.out.println("*** ArithmeticException is caught in main() ***");
//            e.printStackTrace();
//        }

//        divideWithCheckedExceptionMustBeDeclaredAsThrowsException(10,0); // Checked exception has to be either handled with try-catch or thrown to the next calling stack method

        try {
            divideWithCheckedExceptionMustBeDeclaredAsThrowsException(10, 0);
        } catch (Exception e) {
            System.out.println("*** Exception is caught in main() ***");
            e.printStackTrace();
        }

    }

    public static void divideNoExceptionHandling(int a, int b) {
        System.out.println(a / b);
    }

    public static void divideWithExceptionHandling(int a, int b) {
        try {
            System.out.println("*** Here is result: " + a / b + " ***");
            System.out.println("*** ArithmeticException is thrown in try part of divideWithExceptionHandling() method");
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("*** ArithmeticException is caught in divideWithExceptionHandling() method***");
        } finally {
            System.out.println("*** Finally got out this shit away ***");
        }
    }

    public static void divideWithUncheckedExceptionThrown(int a, int b) {
          if (b == 0) {
              throw new ArithmeticException("*** ArithmeticException is thrown ***");
          } else {
              System.out.println("*** Here is result: " + a / b + " ***");
          }
    }

    public static void divideWithUncheckedExceptionNotThrown(int a, int b) throws ArithmeticException /*unchecked exception = unnecessary to declare*/{
        if (b == 0) {
            throw new ArithmeticException("*** ArithmeticException is thrown ***");
        } else {
            System.out.println("*** Here is result: " + a / b + " ***");
        }
        System.out.println("End up this shit");
    }

    public static void divideWithCheckedExceptionMustBeDeclaredAsThrowsException(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("** Exception is thrown. Checked Exception must be either handled with try-catch or thrown to the next calling stack method ***");
        } else {
            System.out.println("*** Here is result: " + a / b + " ***");
        }
    }

}
