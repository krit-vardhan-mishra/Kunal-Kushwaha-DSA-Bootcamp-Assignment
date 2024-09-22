package Easy;
public class MinCostToMoveChips {
    public static int minCostToMoveChips(int[] position) {
        int evenCount = 0, oddCount = 0;

        for (int i : position) {
            if(i % 2 == 0) evenCount++;
            else oddCount++;
        }

        if(evenCount > oddCount) return oddCount;
        else return evenCount;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(minCostToMoveChips(arr));
    }
}
