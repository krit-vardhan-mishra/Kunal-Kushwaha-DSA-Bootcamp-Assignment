import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();        
        backtracking(0, target, res, new ArrayList<>(), candidates);
        
        return res;
    }
    
    public void backtracking(int i, int target, List<List<Integer>> res, List<Integer> sol, int[] nums) {
        if(i == nums.length) {
            if(target == 0) {
                res.add(new ArrayList<>(sol));
            }
            return;
        }

        if(nums[i] <= target) {
            sol.add(nums[i]);
            backtracking(i, target - nums[i], res, sol, nums);
            sol.remove(sol.size()-1);
        }
                
        backtracking(i + 1, target, res, sol, nums);
    }
}
