import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {
//        testJdkArray();
//        testArray();

        Array<Integer> array = new ArrayImpl<>();
        array.add(2);
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(3);

        System.out.println(array);
//        array.sortBubble();
//        array.sortSelect();
        array.sortInsert();
//        System.nanoTime();
//        TimeUnit.NANOSECONDS.toMillis();
        System.out.println(array);

    }

    private static void testArray() {
        //        Array<Integer> array = new ArrayImpl<>();
        Array<Integer> array = new SortedArrayImpl<>();
        System.out.println(array);
        array.add(2);
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(3);

        System.out.println(array);

        System.out.println("Find 5 = " + array.contains(5));
        System.out.println("Index of 3 = " + array.indexOf(3));
        System.out.println("Index of 33 = " + array.indexOf(33));

        System.out.println("Remove 3: " + array.remove(3));
        System.out.println("Remove 33: " + array.remove(33));
        System.out.println("Index of 3 = " + array.indexOf(3));

        System.out.println(array);
        System.out.println("Size is " + array.getSize());

        System.out.println("----------");
        for (int i = 0; i < array.getSize(); i++) {
            System.out.println(array.get(i));
        }
    }

    private static void testJdkArray() {
        //        Integer[] array = new Integer[] {1, 2, 3, 4, 5};
        Integer[] array = {1, 2, 3, 4, 5};


//        array[0] = 5;
//        array[2] = 48;
        for (Integer value : array) {
            System.out.println(value);
        }
    }
}
