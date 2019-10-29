import java.util.*;

public class TopKFrequentElements {


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        List<Integer> res = new ArrayList<>();

        while (res.size() < k) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }


    public List<Integer> topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (map.containsKey(freq)) {
                freqMap.get(freq).add(num);
            } else {
                freqMap.put(freq, new ArrayList<>());
                freqMap.get(freq).add(num);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (res.size() < k) {
            res.addAll(freqMap.pollLastEntry().getValue());
        }

        return res;
    }


    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }

        List<Integer> res = new ArrayList<>();

        int i = bucket.length - 1;
        int cnt = 0;

        while (cnt < k) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                cnt += bucket[i].size();
            }

            i--;
        }

        return res;
    }

//    /**
//     * Priority Queue
//     *
//     * @param nums
//     * @param k
//     * @return
//     */
//    public List<Integer> topKFrequent2(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            maxHeap.offer(entry);
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        while (res.size() < k) {
//            res.add(maxHeap.poll().getKey());
//        }
//
//        return res;
//    }
//
//    /**
//     * TreeMap
//     *
//     * @param nums
//     * @param k
//     * @return
//     */
//    public List<Integer> topKFrequent3(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
//
//        for (int num : map.keySet()) {
//            int freq = map.get(num);
//
//            if (freqMap.containsKey(freq)) {
//                freqMap.get(freq).add(num);
//            } else {
//                freqMap.put(freq, new ArrayList<>());
//                freqMap.get(freq).add(num);
//            }
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        while (res.size() < k) {
//            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
//            res.addAll(entry.getValue());
//        }
//
//        return res;
//    }
//
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//
//        List<Integer>[] bucket = new List[nums.length + 1];
//
//        for (int num : map.keySet()) {
//            int freq = map.get(num);
//
//            if (bucket[freq] == null) {
//                bucket[freq] = new ArrayList<>();
//            }
//
//            bucket[freq].add(num);
//        }
//
//        List<Integer> res = new ArrayList<>();
//
//        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
//            if (bucket[i] != null) {
//                res.addAll(bucket[i]);
//            }
//        }
//
//        /**
//
//         for (int i = bucket.length - 1; i >= 0 ; i--) {
//         int j = 0;
//
//         while (bucket[i] != null && j < bucket[i].size() && k > 0) {
//         res.add(bucket[i].get(j++));
//         k--;
//         }
//         }
//         **/
//
//        return res;
//    }
}
