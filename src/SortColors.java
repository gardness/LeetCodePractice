public class SortColors {

    /**
     *
     * test case : 0 1 2 0
     * time : O(n)  space : O(1)
     *
     * @param nums
     */

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0
        int left = 0;
        int right = nums.length - 1;

        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left++, index++);
            } else if (nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right--);
            }
        }

        return;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
