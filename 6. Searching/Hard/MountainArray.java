interface MountainArray {
    public int get(int index) {}
    public int length() {}
}

public class MountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int index = binarySearch(mountainArr, target, 0, peak, true);
        if (index != -1)
            return index;
        return binarySearch(mountainArr, target, peak + 1, mountainArr.length() - 1, false);
    }

    private int findPeak(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int binarySearch(MountainArray mountainArr, int target, int start, int end, boolean ascending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target)
                return mid;
            if (ascending) {
                if (target < midValue) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > midValue) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
