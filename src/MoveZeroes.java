public class MoveZeroes {


    /**
     * Most of the elements are non-zeros.
     * Num of operations : nums.length
     *
     * @param nums
     */

    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }

        while (start < nums.length) {
            nums[start++] = 0;
        }

        return;
    }


    /**
     * Most of the elements are zeros.
     * Num of operations : 2 * num of non-zeros
     *
     * @param nums
     */

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }

        return;
    }
}
