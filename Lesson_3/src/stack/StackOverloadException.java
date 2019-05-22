package stack;

public class StackOverloadException extends RuntimeException {

    public StackOverloadException() {
        super("ru.geekbrains.datastructure.stack.Stack is full");
    }
}
