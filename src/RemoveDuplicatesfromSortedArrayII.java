public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cnt = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[cnt - 2]) {
                nums[cnt++] = nums[i];
            }
        }

        return cnt;
    }
}
