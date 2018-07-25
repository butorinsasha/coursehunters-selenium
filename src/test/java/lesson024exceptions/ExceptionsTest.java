package lesson024exceptions;

public class ExceptionsTest {

    public static void main(String[] args) {

//        divideNoExceptionHandling(10, 0);
//        divideWithExceptionHandling(10, 0);

//        divideWithUncheckedExceptionThrown(10, 0);

        try {
            divideWithUncheckedExceptionNotThrown(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("*** ArithmeticException is caught but in main() ***");
            e.printStackTrace();
        }

//        try {
//            divideWithCheckedExceptionMustBeThrown(10, 0);
//        } catch (Exception e) {
//            System.out.println("*** Exception is caught but in main() ***");
//            e.printStackTrace();
//        }

    }

    public static void divideNoExceptionHandling(int a, int b) {
        System.out.println(a / b);
    }

    public static void divideWithExceptionHandling(int a, int b) {
        try {
            System.out.println("*** Here is result: " + a / b + " ***");
        } catch (ArithmeticException e) {
//            e.printStackTrace();
            System.out.println("*** ArithmeticException is caught, but is handled ***");
        } finally {
            System.out.println("*** Finally got out this shit away ***");
        }
    }

    public static void divideWithUncheckedExceptionThrown(int a, int b) {
          if (b == 0) {
              throw new ArithmeticException("*** ArithmeticException is caught, but is not handled ***");
          } else {
              System.out.println("*** Here is result: " + a / b + " ***");
          }
    }

    public static void divideWithUncheckedExceptionNotThrown(int a, int b) throws ArithmeticException /*unchecked exception = unnecessary to declare*/{
        if (b == 0) {
            throw new ArithmeticException("*** ArithmeticException is caught, but is not handled ***");
        } else {
            System.out.println("*** Here is result: " + a / b + " ***");
        }
        System.out.println("End up this shit");
    }

    public static void divideWithCheckedExceptionMustBeThrown(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("** Checked Exception must be and is thrown ***");
        } else {
            System.out.println("*** Here is result: " + a / b + " ***");
        }
    }

}
