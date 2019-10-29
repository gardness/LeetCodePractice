import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }

        String res = "";
        String[] strs = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;

                return s2.compareTo(s1);
            }
        });

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

}
