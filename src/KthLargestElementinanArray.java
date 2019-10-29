package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray {

    /**
     * time : O(n)  space : O(1)
     * @param nums
     * @param k
     * @return
     */

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
            } else if (pos + 1 < k) {
                left = pos + 1;
            } else {
                right = pos - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int start = left;

        left += 1;

        while (left <= right) {
            if (nums[left] < pivot && nums[right] > pivot) {
                swap(nums, left++, right--);
            }

            if (nums[left] >= pivot) {
                left++;
            }

            if (nums[right] <= pivot) {
                right--;
            }
        }

        swap(nums, start, right);

        return right;
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }


    public int findKthLargest2(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue();

        for (int num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
