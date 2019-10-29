import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums1);

        for (int num : nums2) {
            if (binarySearch(nums1, num)) {
                set.add(num);
            }
        }

        int k = 0;
        int[] res = new int[set.size()];

        for (Integer num : set) {
            res[k++] = num;
        }

        return res;
    }

    public static boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return false;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        int k = 0;
        int[] res = new int[set.size()];

        for (Integer num : set) {
            res[k++] = num;
        }

        return res;
    }


    public static int[] intersection3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> ret = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                ret.add(num);
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
