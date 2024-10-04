
public class CustomDynamicStack extends CustomStack {

    public CustomDynamicStack() {
        super();
    }

    public CustomDynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int val) {
        if(isFull()) {
            resize();
        }

        return super.push(val);
    }

    @Override
    public int pop() throws Exception {
        return super.pop();
    }

    private void resize() {
        int[] temp = new int[(data.length*3)/2 + 1];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }
    
}