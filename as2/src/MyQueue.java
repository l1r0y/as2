public class MyQueue<T> {
    private MyLinkedList<T> list;

    public MyQueue() {
        list = new MyLinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        if (list.size() == 0)
            throw new IllegalStateException("Queue is empty");
        T item = list.getFirst();
        list.removeFirst();
        return item;
    }

    public T peek() {
        if (list.size() == 0)
            throw new IllegalStateException("Queue is empty");
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public static void test() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assert queue.size() == 3;
        assert queue.peek() == 1;
        assert queue.dequeue() == 1;
        assert queue.size() == 2;
        assert queue.peek() == 2;

        queue.dequeue();
        queue.dequeue();
        assert queue.isEmpty();
    }
}