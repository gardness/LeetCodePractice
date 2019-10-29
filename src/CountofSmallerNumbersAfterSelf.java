import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            Integer index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }

        return Arrays.asList(res);
    }

    private int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) {
            return 0;
        }

        int left = 0;
        int right = list.size() - 1;

        if (list.get(left) > target) {
            return 0;
        }

        if (list.get(right) < target) {
            return list.size();
        }

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (list.get(mid) < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (list.get(left) >= target) {
            return left;
        } else {
            return right;
        }
    }

}
