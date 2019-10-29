import java.util.*;

public class ShuffleanArray {
    /**
     * 384. Shuffle an Array
     * // Init an array with set 1, 2, and 3.
     int[] nums = {1,2,3};
     Solution solution = new Solution(nums);

     // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
     solution.shuffle();

     // Resets the array back to its original configuration [1,2,3].
     solution.reset();

     // Returns the random shuffling of array [1,2,3].
     solution.shuffle();

     time : O(n)
     * @param nums
     */


    int[] nums;
    Random rand;

    // 题中的构造函数是Solution
    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] clone = nums.clone();

        for (int i = 0; i < clone.length; i++) {
            int rnd = rand.nextInt(i + 1);
            swap(clone, i, rnd);
        }
        return clone;
    }

    public int swap(int[] clone, int i, int j) {
        int tmp = clone[i];
        clone[i] = clone[j];
        clone[j] = tmp;

        return 0;
    }
}
