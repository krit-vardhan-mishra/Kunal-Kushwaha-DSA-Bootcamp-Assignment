public class PeakIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 1, end = arr.length-2;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if(arr[mid] > arr[mid-1]) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
