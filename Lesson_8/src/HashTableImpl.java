public class HashTableImpl implements HashTable {

    private static class Entry {
        private Item key;
        private int value;
        private Entry nextEntry = null;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public Entry next() {
            return nextEntry;
        }

        public void setNext(Entry nextEntry) {
            this.nextEntry = nextEntry;
        }

        public boolean hasNext() {
            return nextEntry != null;
        }
    }


    private Entry[] data;
    private int size;
    private int maxSize;

    public HashTableImpl(int maxSize) {
        this.data = new Entry[maxSize * 2];
        this.maxSize = maxSize;
    }

    private int hashFunc(Item key) {
        return key.hashCode() % data.length;
    }

    @Override
    public boolean put(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int count = 0;
        int index = hashFunc(item);
        while (data[index] != null) {
            if (count >= data.length) {
                index++;
                count = 0;
            }
            index += getStep(item);
            index %= data.length;
            count++;
        }


        data[index] = new Entry(item, cost);
        count++;
        size++;

        return true;
    }

    @Override
    public boolean put2(Item item, Integer cost) {
        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item);
        Entry current = data[index];
        Entry previos = null;

        if (current != null) {

            while (current.hasNext()) {
                previos = current;
                current = current.next();
            }
            current.setNext(new Entry(item, cost));
        } else {
            data[index] = new Entry(item, cost);
            size++;
        }

        return true;
    }

    protected int getStep(Item item) {
        return 1;
    }

    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        return index != -1 ? data[index].value : null;
    }

    private int indexOf(Item item) {
        int index = hashFunc(item);
        int count = 0;

        while (data[index] != null && count < data.length) {
            Entry entry = data[index];
            if (entry.key.equals(item)) {
                return index;
            }

            index += getStep(item);
            index %= data.length;
            count++;
        }

        return -1;
    }

    @Override
    public Integer get2(Item item) {
        Integer cost = -1;
        int index = hashFunc(item);
        if (data[index] == null) return cost;
        if (data[index] != null) {
            if (data[index].key.getTitle().equals(item.getTitle())) {
                cost = data[index].value;
            } else {
                Entry current = data[index];

                while (current.hasNext()) {

                    current = current.next();
                    if (current.key.equals(item)) {
                        cost = current.value;
                    }
                }
            }

        }
        return cost;
    }


    @Override
    public boolean remove2(Item item) {
        boolean flag = false;
        int index = hashFunc(item);
        if (data[index] == null) return flag;
        if (data[index] != null) {
            if (data[index].key.getTitle().equals(item.getTitle())) {
                Entry current = data[index];
                if (current.hasNext()) {
                    current = current.next();
                    data[index] = current;
                } else {
                    data[index] = null;
                    size--;
                }
            } else {

                Entry current = data[index];
                while (current.hasNext()) {
                    Entry previos = current;
                    current = current.next();
                    if (current.key.equals(item)) {
                        previos.setNext(current.next());
                        current = null;
                        break;
                    }
                }

            }

        }

        return flag;
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != -1) {
            data[index] = null;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("----------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s]", i, data[i]));
            if (data[i] != null) {
                if (data[i].hasNext()) {
                    Entry current = data[i];

                    System.out.println("Цепочка у " + data[i].key.getTitle());

                    while (current.hasNext()) {
                        current = current.next();
                        System.out.println("Элемент в цепочке: " + current.key.getTitle());

                    }
                }
            }
        }
        System.out.println("----------");
    }
}
