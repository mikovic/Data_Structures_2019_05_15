import java.util.HashMap;
import java.util.Map;

public class Main8 {

    public static void main(String[] args) {
//        HashTable hashTable = new HashTableImpl(5);//5 * 2 = 10
        HashTable hashTable = new DoubleHashTableImpl(5);//5 * 2 = 10

        hashTable.put2(new Item(1, "Orange"), 150);
        hashTable.put2(new Item(77, "Banana"), 100);
        hashTable.put2(new Item(60, "Lemon"), 250);
        hashTable.put2(new Item(21, "Potato"), 67);
        hashTable.put2(new Item(55, "Milk"), 120);

        System.out.println("Size is " + hashTable.getSize());
        hashTable.display();

        System.out.println("Cost potato is " + hashTable.get2(new Item(21, "Potato")));
        System.out.println("Cost banana is " + hashTable.get2(new Item(77, "Banana")));


        hashTable.remove2(new Item(77, "Banana"));
        hashTable.remove2(new Item(21, "Orange"));

        System.out.println("Cost banana is after removing " + hashTable.get2(new Item(77, "Banana")));

        hashTable.display();
        System.out.println("Вставили апельсин опять. Поменялся местами с potato: ");
        hashTable.put2(new Item(1, "Orange"), 150);
        hashTable.display();

        Map<String, Integer> map = new HashMap<>();
        for (String s : map.keySet()) {
            Integer value = map.get(s);
        }

        map.forEach((k, v) -> {

        });

    }
}