import java.util.ArrayList;
import java.util.NoSuchElementException;

// - Complete Binary Tree
// - Every Node value >= All its Children (Max Heap) 
// - Every Node value <= All its Children (Min Heap)
// - Parent(i) = i/2
// - Left Child(i) = 2 * i
// - Right Child(i) = 2 * i + 1

class MinHeap<T extends Comparable<T>> {

    private ArrayList<T> list;
    
    public MinHeap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if (index == 0) return;

        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) < 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T delete() throws Exception {
        if (list.isEmpty()) throw new NoSuchElementException("Removing from an Empty Heap.");

        T temp = list.get(0);
        T last = list.remove(list.size()-1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) > 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.delete());
        }

        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

class MaxHeap<T extends Comparable<T>> {

    private ArrayList<T> list;
    
    public MaxHeap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return (index * 2) + 1;
    }

    private int right(int index) {
        return (index * 2) + 2;
    }

    public void insert(T value) {
        list.add(value);
        upheap(list.size()-1);
    }

    private void upheap(int index) {
        if (index == 0) return;

        int p = parent(index);
        if (list.get(index).compareTo(list.get(p)) > 0) {
            swap(index, p);
            upheap(p);
        }
    }

    public T delete() throws Exception {
        if (list.isEmpty()) throw new NoSuchElementException("Removing from an Empty Heap.");

        T temp = list.get(0);
        T last = list.remove(list.size()-1);

        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min).compareTo(list.get(left)) < 0) {
            min = left;
        }

        if (right < list.size() && list.get(min).compareTo(list.get(right)) < 0) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();

        while (!list.isEmpty()) {
            data.add(this.delete());
        }

        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Heaps {
    public static void main(String[] args) throws Exception {
        MinHeap<Integer> minheap = new MinHeap<>();
        minheap.insert(34);
        minheap.insert(45);
        minheap.insert(22);
        minheap.insert(89);
        minheap.insert(76);

        System.out.println(minheap.toString());
        ArrayList<Integer> minlist = minheap.heapSort();
        System.out.println(minlist);

        MaxHeap<Integer> maxheap = new MaxHeap<>();
        maxheap.insert(34);
        maxheap.insert(45);
        maxheap.insert(22);
        maxheap.insert(89);
        maxheap.insert(76);

        System.out.println(maxheap.toString());
        ArrayList<Integer> maxlist = maxheap.heapSort();
        System.out.println(maxlist);
    }
}
