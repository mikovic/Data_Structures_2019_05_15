package queue;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFUALT_REAR = -1;
    private static final int DEFAULT_FRONT = 0;

    protected E[] data;
    protected int size;

    protected int front;
    protected int rear;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxSize) {
        this((E[]) new Object[maxSize]);
    }

    protected QueueImpl(E[] data) {
        this.data = data;
        this.front = DEFAULT_FRONT;
        this.rear = DEFUALT_REAR;
    }

    @Override//O(1)
    public void insert(E value) {
        if (isFull()) {
            throw new RuntimeException("queue is full");
        }

        if (rear == data.length - 1) {
            rear = DEFUALT_REAR;
        }

        data[++rear] = value;
        size++;
    }

    @Override//O(1)
    public E remove() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }

        E value = data[front++];
        size--;

        return value;
    }

    @Override
    public E peek() {
        return data[front];
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
}
