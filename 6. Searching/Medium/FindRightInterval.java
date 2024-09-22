import java.util.TreeMap;

public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i][0], i);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.ceilingKey(intervals[i][1]);
            res[i] = key != null ? map.get(key) : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2}};
        int[] res = findRightInterval(arr);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
