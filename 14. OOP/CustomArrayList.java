import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList {

    int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }

        data[size++] = num;
    }

    public void add(int index, int value) {
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
    }

    private void resize() {
        int[] temp = new int[(data.length * 3) / 2 + 1];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getValue(int index) {
        if (index >= 0 && index < size) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = value;
    }

    public boolean contains(int value) {
        return indexOf(value) > -1;
    }

    public int indexOf(int value) {
        return indexOfRange(value, 0, size);
    }

    int indexOfRange(int value, int start, int end) {
        for (int i = start; i < end; i++) {
            // if(data[i] == value) return i;
            if (Objects.equals(data[i], value))
                return i;
        }
        return -1;
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            data[i] = 0;
    }

    public boolean remove(int value) {
        int idx = indexOf(value);
        if (idx == -1) {
            return false;
        }
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = 0;
        return true;
    }

    public int lastIndexOf(int value) {
        return lastIndexOfRange(value, 0, size);
    }

    int lastIndexOfRange(int value, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            // if(data[i] == value) return i;
            if (Objects.equals(data[i], value))
                return i;
        }
        return -1;
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(" , ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {

        // Main function is now in seperate file.

        // Generics : parameterized types
        // 'ArrayList<>' here '<>' is generics.
        // Generics helps us to give parameter to methods, classes and interfaces of a
        // user-defined type.
        // Using generics to create classes that work with different data types.
        
    }
}