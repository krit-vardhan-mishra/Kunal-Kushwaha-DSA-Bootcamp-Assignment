import java.util.Arrays;
import java.util.Objects;

public class CustomGenArrayList<T extends Comparable<T>> {
    // If you want that Number type ArrayList can be created then you can do :
    // <T extends Number>
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;
    private T maximum;

    public CustomGenArrayList() {
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (isFull()) {
            resize();
        }
        if (maximum == null || value.compareTo(maximum) > 0) {
            maximum = value;
        }
        data[size++] = value;
    }

    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (isFull()) {
            resize();
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        if (maximum == null || value.compareTo(maximum) > 0) {
            maximum = value;
        }
    }

    private void resize() {
        Object[] temp = new Object[(data.length * 3) / 2 + 1];
        // for(int i=0;i<data.length;i++) {
        // temp[i] = data[i];
        // }
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    public T getValue(int index) {
        if (index >= 0 && index < size) {
            return (T) data[index];
        } 
        throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    public T getFirst() {
        if(size == 0) {
            return null;
        }
        return (T)data[0];
    }

    @SuppressWarnings("unchecked")
    public T getLast() {
        if(size == 0) {
            return null;
        } 
        return (T)data[size-1];
    }

    public int size() {
        return size;
    }

    public void set(int index, T value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
        if (maximum == null || value.compareTo(maximum) > 0) {
            maximum = value;
        }
    }

    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    public int indexOf(T value) {
        return indexOfRange(value, 0, size);
    }

    int indexOfRange(T value, int start, int end) {
        for (int i = start; i < end; i++) {
            // if(data[i] == value) return i;
            if (Objects.equals(data[i], value))
                return i;
        }
        return -1;
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            data[i] = null;
        maximum = null;
    }

    public boolean remove(T value) {
        int idx = indexOf(value);
        if (idx == -1) {
            return false;
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        if (value.equals(maximum)) {
            recalculateMaximum();
        }
        return true;
    }

    public boolean removeLast() {
        if(size == 0) return false;
        Object value = data[size-1];
        data[--size] = null;
        if(value.equals(maximum)) recalculateMaximum();
        return true;
    }

    public boolean removeFirst() {
        if(size == 0) return false;
        for(int i=0;i<size-1;i++) {
            data[i] = data[i+1];
        }
        data[--size] = null;
        recalculateMaximum();
        return true;
    }

    private void recalculateMaximum() {
        maximum = null;
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T current = (T) data[i];
            if (maximum == null || current.compareTo(maximum) > 0) {
                maximum = current;
            }
        }
    }

    public int lastIndexOf(T value) {
        return lastIndexOfRange(value, 0, size);
    }

    int lastIndexOfRange(T value, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            // if(data[i] == value) return i;
            if (Objects.equals(data[i], value))
                return i;
        }
        return -1;
    }

    public T getMaximum() {
        return maximum;
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

}
