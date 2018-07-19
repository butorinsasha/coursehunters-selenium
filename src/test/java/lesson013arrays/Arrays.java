package lesson013arrays;

public class Arrays {
    public static void main(String[] args) {
        String[] names;
        names = new String[3];

        String[] name = new String[3];
        int[] arr = new int[10];

        name[0] = "Vasya";
        name[1] = "Petya";
        name[2] = "Vanya";

        System.out.println(name[0]);
        System.out.println(name[2]);
        System.out.println();

        arr[3] = 15;
        arr[3] = 10;
        System.out.println(arr[3]);
        System.out.println();

        int[] array = {15, 10, 100, 4, 44};
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println();

        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

        int[] arr2 = new int[15];
        for (int j = 0; j < 15; j++) {
            arr2[j] = j * 10;
            System.out.println(arr2[j]);
        }

        System.out.println();
        System.out.println(arr2.length);
        System.out.println(arr2[arr2.length-1]);


    }
}
