public class MyStack<T> {
    private MyLinkedList<T> list;

    public MyStack() {
        list = new MyLinkedList<>();
    }

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (list.size() == 0)
            throw new IllegalStateException("Stack is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (list.size() == 0)
            throw new IllegalStateException("Stack is empty");
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public static void test() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assert stack.size() == 3;
        assert stack.peek() == 3;
        assert stack.pop() == 3;
        assert stack.size() == 2;
        assert stack.peek() == 2;

        stack.pop();
        stack.pop();
        assert stack.isEmpty();
    }
}