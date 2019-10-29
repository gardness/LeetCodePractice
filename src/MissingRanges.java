import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();           //  try linkedlist

        if (nums == null || nums.length == 0) {
            return res;
        }

        long llower = (long) lower;
        long lupper = (long) upper;

        for (int num : nums) {
            if (num == llower) {
                llower++;
            } else if (num > llower) {
                if (num == llower + 1) {
                    res.add(llower + "");
                } else if (num > llower + 1) {
                    res.add(llower + "->" + (num - 1));
                }

                llower = (long)num + 1;
            }
        }

        if (llower == lupper) {
            res.add(llower + "");
        } else if (llower < lupper) {
            res.add(llower + "->" + lupper);
        }

        return res;
    }
}
