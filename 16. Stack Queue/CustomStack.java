
public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int val) {
        if(isFull()) {
            System.out.println("No.");
            return false;
        }
        ptr++;
        data[ptr] = val;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("No.");
        }

        return data[ptr--];
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("No.");
        }

        return data[ptr];
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        for (int i = 0; i <= ptr; i++) {
            sb.append(data[i]);
            if(i != ptr) {
                sb.append(" , ");
            }
        }
        
        sb.append(" ]");
        return sb.toString();
    }
    
}