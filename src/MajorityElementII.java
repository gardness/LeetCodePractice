import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    // time : O(n)  space : O(1)
    public static List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int number1 = 0, number2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : nums) {                  //  会报错，为什么？难道前后判断需要有顺序？
            if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        for (int num : nums) {                  //  利用 MajorityElement 中 Moore Voting Algorithm 查询是否有数的出现频率超过了 n/3
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            } else if (count1 == 0) {
                number1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                number2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }


        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == number1) {
                count1++;
            } else if (num == number2) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            res.add(number1);
        }

        if (count2 > nums.length / 3) {
            res.add(number2);
        }

        return res;
    }
}
