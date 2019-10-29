public class RotateArray {

    //  time : O(n)  space : O(n)

    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }

        return;
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
