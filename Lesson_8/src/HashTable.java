public interface HashTable {

    boolean put(Item item, Integer cost);

    Integer get(Item item);

    boolean remove(Item item);

    int getSize();

    boolean isEmpty();

    void display();
    boolean put2(Item item, Integer cost);

    Integer get2(Item item);

    boolean remove2(Item item);
}
