package leetcode;

public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int res = 0;
        int[] bytes = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int tmp = 0;

            for (int j = 0; j < words[i].length(); j++) {
                tmp |= 1 << (words[i].charAt(j) - 'a');
            }

            bytes[i] = tmp;
        }

        for (int i = 0; i < bytes.length; i++){
            for (int j = i + 1; j < bytes.length; j++) {
                if ((bytes[i] &  bytes[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }

    /**
     * Binary Search : Iteration
     * time : O(logn)  space : O(1)
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */

    public int binarySearchIteration(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    /**
     * Is Prime Number
     * time : O(sqrt(n))  space : O(1)
     * @param num
     * @return
     */

    public boolean isPrimeNumber(int num) {
        if (num == 2) {
            return true;
        }

        if (num < 2 || num % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Sum
     * time : O(n)  space : O(1)
     * @param n
     * @return
     */

    public int sum(int n) {
        int res = 0;

        for(int i = 1; i <= n; i++) {
            res += i;
        }
    }


    /**
     * Selection Sort
     * time : O(n^2)  space : O(1)
     * (n - 1) + (n - 2) + ... + 1 + 0 = (0 + n - 1) * n / 2 = O(n^2)
     * @param nums
     */

    public void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }

                swap(nums, i, index);
            }
        }
    }

    /**
     * Swap
     * time : O(1)  space : O(1)
     * @param nums
     * @param i
     * @param j
     */

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        //  int[] test = new int[1000];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
