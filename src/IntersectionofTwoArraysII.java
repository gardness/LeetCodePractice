import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionofTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();

        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                ret.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int k = 0;
        int[] res = new int[ret.size()];

        for (Integer num : ret) {
            res[k++] = num;
        }

        return res;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> ret = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ret.add(nums1[i]);
                i++;
                j++;
            }
        }

        int k = 0;
        int[] res = new int[ret.size()];

        for (Integer num : ret) {
            res[k++] = num;
        }

        return res;
    }
}
