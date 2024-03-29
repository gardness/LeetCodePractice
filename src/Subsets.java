package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * Subset
     * time : O(2^n)  space : O(n)
     * @param nums
     * @return
     */

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }

        return;
    }

}
