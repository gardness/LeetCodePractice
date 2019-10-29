public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[cnt++] = nums[i];
            }
        }

        return cnt;
    }
}
