package Hard;

import java.util.PriorityQueue;

public class FindMaxValueOfEquation {

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int ans = -(1 << 30);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (var p : points) {
            int x = p[0], y = p[1];
            while (!pq.isEmpty() && x - pq.peek()[1] > k) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                ans = Math.max(ans, x + y + pq.peek()[0]);
            }
            pq.offer(new int[] {y - x, x});
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
        System.out.println(findMaxValueOfEquation(points, 1));
    }
}