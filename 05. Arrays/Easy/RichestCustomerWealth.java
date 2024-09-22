package Easy;
public class RichestCustomerWealth {
    public static int maximumWealth(int[][] accounts) {
        int maxi = 0;

        for (int i = 0; i < accounts.length; i++) {
            int running_sum = 0;
            for (int j = 0; j < accounts[0].length; j++) {
                running_sum += accounts[i][j];
            }
            maxi = Math.max(maxi, running_sum);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(maximumWealth(accounts));
    }
}
