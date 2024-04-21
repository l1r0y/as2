public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    public void add(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T peek() {
        if (heap.size() == 0)
            throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public T remove() {
        if (heap.size() == 0)
            throw new IllegalStateException("Heap is empty");
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex, rightChildIndex, minIndex;
        while (true) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
            minIndex = index;

            if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(minIndex)) < 0)
                minIndex = leftChildIndex;

            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(minIndex)) < 0)
                minIndex = rightChildIndex;

            if (minIndex != index) {
                swap(index, minIndex);
                index = minIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public static void test() {
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(3);
        heap.add(2);
        heap.add(1);

        assert heap.size() == 3;
        assert heap.peek() == 1;
        assert heap.remove() == 1;
        assert heap.size() == 2;
        assert heap.peek() == 2;

        heap.remove();
        heap.remove();
        assert heap.isEmpty();
    }
}