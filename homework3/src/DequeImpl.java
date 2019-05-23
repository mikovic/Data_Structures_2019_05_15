import queue.Queue;
import queue.QueueImpl;

public class DequeImpl<E> implements Deque<E> {

    private static final int DEFUALT_REAR = -1;
    private static final int DEFAULT_FRONT = 0;

    protected E[] data;
    protected int size;

    private int front;
    private int rear;

    @SuppressWarnings("unchecked")
    public DequeImpl(int maxSize) {
        this((E[]) new Object[maxSize]);
    }

    protected DequeImpl(E[] data) {
        this.data = data;
        this.front = DEFAULT_FRONT;
        this.rear = DEFUALT_REAR;
    }

    @Override
    public void insertRight(E value) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }

        if (rear == data.length - 1) {
            rear = DEFUALT_REAR;
        }

        data[++rear] = value;
        size++;

    }

    @Override
    public void insertLeft(E value) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }

        for (int i=size-1; i>=0; i-- ) {
            data[i+1] = data[i];



        }
        data[0] = value;
        size++;
        rear = size-1;


    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        E value = data[0];
        for (int i = 0; i < size ; i++) {
            data[i] = data[i + 1];
        }

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }
        front = DEFAULT_FRONT;
        rear = size - 1;

        size--;


        return value;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (front == data.length) {
            front = DEFAULT_FRONT;
        }

        E value = data[rear];
        data[rear] = null;
        rear--;
        size--;

        return value;
    }



    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }

    public void display() {
        for (E temp : this.data) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }
}
