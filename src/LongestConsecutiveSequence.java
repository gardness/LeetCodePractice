import java.util.HashSet;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int down = num - 1;

            while (set.contains(down)) {
                set.remove(down);
                down--;
            }

            int up = num + 1;

            while (set.contains(up)) {
                set.remove(up);
                up++;
            }

            res = Math.max(res, up - down - 1);
        }

        return res;
    }
}
