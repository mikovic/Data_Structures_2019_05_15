import src.Array;
import src.SortedArrayImpl;

public class RecSortedArrayImpl<E extends Object & Comparable<? super E>> extends SortedArrayImpl<E> {

    public static void main(String[] args) {
        Array<Integer> array = new RecSortedArrayImpl<>();
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
    }

    @Override
    public int indexOf(E value) {
        return recBinaryFind(value, 0, currentSize - 1);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (data[mid].equals(value)) {
            return mid;
        }

        if (value.compareTo(data[mid]) > 0) {
            return recBinaryFind(value, mid + 1, high);
        }
        else {
            return recBinaryFind(value, low, mid - 1);
        }
    }
}