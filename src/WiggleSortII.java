package leetcode;

import java.util.Arrays;

public class WiggleSortII {

    /**
     * time : O(nlogn)   （注意这里其实是 O(max(nlogn, n)） = O(nlogn)，要小心！）
     * space : O(n)
     * @param nums
     */

    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int mid = (n - 1) / 2;
        int index = 0;
        int[] tmp = new int[n];

        for (int i = 0; i <= mid; i++) {
            tmp[index] = nums[mid - i];

            if (index + 1 < n) {
                tmp[index + 1] = nums[n - 1 - i];
            }

            index += 2;
        }

        System.arraycopy(tmp, 0, nums, 0, n);
    }


    public void wiggleSort2(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;
        int left = 0, right = n - 1;
        int index = 0;

        while (index <= right) {
            if (nums[newIndex(index, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(index++, n));
            } else if (nums[newIndex(index, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(index, n));
            } else {
                index++;
            }
        }
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) %(n | 1);
    }

    public int findKthLargest(int[] nums, int k){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int pos = partition(nums, left, right);

            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;

        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }

            if (nums[l] >= pivot) {
                l++;
            }

            if (nums[r] <= pivot) {
                r--;
            }
        }

        swap(nums, left, r);

        return r;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
