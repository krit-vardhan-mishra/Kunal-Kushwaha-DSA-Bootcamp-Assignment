import java.util.ArrayList;

class Heap {
    static class MinHeap {
        private ArrayList<Integer> list;
        private int capacity;
        private int index;

        MinHeap(int capacity) {
            this.capacity = capacity;
            this.list = new ArrayList<>(capacity);
            this.index = 0;
        }

        void insert(int value) throws Exception {
            if (index < 0 || index >= capacity) throw new Exception();

            list.add(index, value);
            index++;
            shiftUp(list.size()-1);
        }

        int parent(int index) {return (index-1)/2;}
        int left(int index) {return 2 * index + 1;}
        int right(int index) {return 2 * index + 2;}

        void shiftUp(int index) {
            if (index > 0 && list.get(parent(index)) > list.get(index)) {
                swap(parent(index), index);
                shiftUp(parent(index));
            }
        }

        void shiftDown(int index) {
            int left = left(index), right = right(index);
            int temp = index;

            if (left < this.index && list.get(left) < list.get(temp)) temp = left;
            if (right < this.index && list.get(right) < list.get(temp)) temp = right;

            if (temp != index) {
                swap(index, temp);
                shiftDown(temp);
            }
        }

        void decreaseKey(int i, int k) {
            list.set(i, k);

            while (i != 0 && list.get(parent(i)) > list.get(i)) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        int delete() {
            int last = list.get(index-1);
            decreaseKey(index-1, Integer.MIN_VALUE);
            extractMin();
            return last;
        }

        void buildHeap(int[] arr) {
            for (int i= (index-2)/2; i >= 0; i--) {
                shiftDown(i);
            }
        }

        void swap(int a, int b) {
            int temp = list.get(a);
            list.set(a, list.get(b));
            list.set(b, temp);
        }

        int extractMin() {
            if (index == 0) return Integer.MAX_VALUE;
            if (index == 1) {
                index--;
                return list.get(0);
            }

            swap(0, index-1);
            index--;
            shiftDown(0);
            return list.get(index);
        }

        int getMinimum() {
            return list.get(0);
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

    static class MaxHeap {
        private ArrayList<Integer> list;
        private int capacity;
        private int index;

        MaxHeap(int capacity) {
            this.capacity = capacity;
            this.list = new ArrayList<>(capacity);
            this.index = 0;
        }

        void insert(int value) throws Exception {
            if (index < 0 || index >= capacity) throw new Exception();

            list.add(index, value);
            index++;
            shiftUp(list.size()-1);
        }

        int parent(int index) {return (index-1)/2;}
        int left(int index) {return 2 * index + 1;}
        int right(int index) {return 2 * index + 2;}

        void shiftUp(int index) {
            if (index > 0 && list.get(parent(index)) < list.get(index)) {
                swap(parent(index), index);
                shiftUp(parent(index));
            }
        }

        void shiftDown(int index) {
            int left = left(index), right = right(index);
            int temp = index;
            
            if (left < this.index && list.get(left) > list.get(temp)) temp = left;
            if (right < this.index && list.get(right) > list.get(temp)) temp = right;

            if (temp != index) {
                swap(index, temp);
                shiftDown(temp);
            }
        }

        int extractMax() {
            if (index == 0) return Integer.MIN_VALUE;
            if (index == 1) {
                index--;
                return list.get(0);
            }

            swap(0, index-1);
            index--;
            shiftDown(0);
            return list.get(index);
        }

        int getMax() {
            return list.get(0);
        }

        void decreaseKey(int i, int k) {
            list.set(i, k);

            while (i != 0 && list.get(parent(i)) < list.get(i)) {
                swap(i, parent(i));
                i = parent(i);
            }
        }

        int delete() {
            int last = list.get(index-1);
            decreaseKey(index-1, Integer.MAX_VALUE);
            extractMax();
            return last;
        }

        void buildHeap(int[] arr) {
            for (int i= (index-2)/2; i >= 0; i--) {
                shiftDown(i);
            }
        }

        void swap(int a, int b) {
            int temp = list.get(a);
            list.add(a, list.get(b));
            list.add(b, temp);
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
        
}