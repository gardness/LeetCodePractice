public class SearchforaRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = findFirst(nums, target);
        int right = findSecond(nums, target);

        return new int[]{left, right};
    }

    public int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        }

        if (nums[right] == target) {
            return right;
        }

        return -1;
    }

    public int findSecond(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }

        if (nums[left] == target) {
            return left;
        }

        return -1;
    }
}
