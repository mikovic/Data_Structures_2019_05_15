package stack;

public class StackImpl<E> implements Stack<E> {

    private E[] data;
    private int maxSize;
    private int size;

    public StackImpl(int maxSize) {
        this.data = createArray(maxSize);
        this.maxSize = maxSize;
    }

    @SuppressWarnings("unchecked")
    private E[] createArray(int maxSize) {
        return (E[]) new Object[maxSize];
    }

    @Override//O(1)
    public void push(E value) {
        if (isFull()) {
            throw new StackOverloadException();
        }
        data[size++] = value;
    }

    @Override//O(1)
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("ru.geekbrains.datastructure.stack.Stack is empty!");
        }

        E value = data[--size];
        data[size] = null;
        return value;
    }

    @Override//O(1)
    public E peek() {
        return data[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override//O(1)
    public void clear() {
        this.data = createArray(maxSize);
        this.size = 0;
//        while ( !isEmpty() ) {
//            pop();
//        }
    }
}
