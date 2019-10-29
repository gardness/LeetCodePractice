import java.util.HashMap;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;

        for (int i = 1; i < res.length; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    res[i] += res[i - num];
                }
            }
        }

        return res[target];
    }

    public int combinationSum42(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        return helper(nums, target, map);
    }

    private int helper(int[] nums, int target, HashMap<Integer, Integer> map) {
        if (target < 0) {
            return 0;
        }

        if (target == 0) {
            return 1;
        }

        if (map.containsKey(target)) {
            return map.get(target);
        }

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res += helper(nums, target - nums[i], map);
        }

        map.put(target, res);

        return res;
    }
}
