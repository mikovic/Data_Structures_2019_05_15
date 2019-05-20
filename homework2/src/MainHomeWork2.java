import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainHomeWork2 {


    public static void main(String[] args) {
        Random random = new Random();

        Integer[] array = new Integer[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(51);

        }
        array = add(array, 100);
        show(array);
        array = remove(array, array[2]);
        show(array);
        Integer[] array0 = new Integer[100000];
        for (int i = 0; i < array0.length; i++) {
            array0[i] = random.nextInt(51);

        }
        Integer[] array1 = array0;
        Integer[] array2 = array0;
        Integer[] array3 = array0;
        long millis1 = System.currentTimeMillis();
        sortBubble(array1);
        long millis2 = System.currentTimeMillis();
        long during = millis2 - millis1;
        System.out.println("sortBubles: "+ during);
        millis1 = System.currentTimeMillis();
        sortInsert(array2);
        millis2 = System.currentTimeMillis();
        during = millis2 - millis1;
        System.out.println("sortInsert: "+ during);
        millis1 = System.currentTimeMillis();
        sortSelect(array3);
        millis2 = System.currentTimeMillis();
        during = millis2 - millis1;
        System.out.println("sortSelect: "+ during);


    }
    public  static <T extends Comparable<T>> T[] add( T[] array, T value) {
        int newLength = array.length + 1;
        array = Arrays.copyOf(array, newLength );

        array[newLength - 1] = value;
        return array;
    }

    public  static <T extends Comparable<T>> T[] remove(T[] array, T value) {
        int index = indexOf(array, value);
        if (index == -1) {
            return null;
        }

        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array = Arrays.copyOf(array, array.length - 1);

        return array;
    }
    public static <T extends Comparable<T>> int indexOf(T[]array, T value) {
        for (int i = 0; i < array.length; i++) {
            if ((array[i]).equals(value)) {
                return i;
            }
        }

        return -1;
    }



    public static <T extends Comparable<T>> void sortBubble(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if ((array[j].compareTo(array[j + 1])) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static <T extends Comparable<T>> void sortSelect( T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, minIndex, i);
            }
        }
    }


    public static <T extends Comparable<T>> void sortInsert(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];

            int in = i;
            while (in > 0 && array[in - 1].compareTo(temp) >= 0) {
                array[in] = array[in -1];
                in--;
            }

            array[in] = temp;
        }
    }

    private static <T extends Comparable<T>> void swap(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static <T extends Comparable<T>> void show(T[] array) {
        System.out.println(Stream.of(array)
                .limit(array.length)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]")));

    }

}
