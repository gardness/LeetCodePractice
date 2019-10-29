import java.util.Arrays;
import java.util.HashMap;

public class MajorityElement {

    //  time : O(nlogn)  space : O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }

    //  time : O(n)  space : O(n)
    public int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }

            if (map.get(num) > nums.length / 2) {
                res = num;
                break;
            }
        }

        return res;
    }

    //  time : O(n)  space : O(1)
    public int majorityElement3(int[] nums) {
        int res = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                res = num;
            }

            if (num != res) {
                count--;
            } else {
                count++;
            }
        }

        return res;
    }
}
