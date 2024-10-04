package Medium;

class FirstAndLastElement {
    public static int[] searchRange(int[] nums, int target) {
        int first = firstOcc(nums,target);
        if(first == -1) return new int[]{-1,-1};
        int last = lastOcc(nums,target);
        return new int[]{first,last};
    }
    
    public static int firstOcc(int[] nums, int target) {
        int start = 0, end = nums.length-1, first = -1;
        
        while(start <= end) {
            int mid = (start+end) / 2;
            
            if(nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }
    
    public static int lastOcc(int[] nums, int target) {
        int start = 0, end = nums.length-1, last = -1;
        
        while(start <= end) {
            int mid = (start+end) / 2;
            
            if(nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
    }
   public static void main(String[] args) {
    int[] arr = {5,7,7,8,8,10};
    int[] res = searchRange(arr,7);
    for (int i : res) {
        System.out.print(i+" ");
    }
   } 
}
