public class MissingNumber {

    public int missingNumber(int[] nums) {
        int res = nums.length;

        for(int i = 0; i < nums.length; i++){
            res ^= i ^ nums[i];
        }

        return res;
    }

    public int missingNumber2(int[] nums) {
        int expectedSum = (1 + nums.length) * nums.length / 2;

        int actualSum = 0;

        for(int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
