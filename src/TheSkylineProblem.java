import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if (buildings == null) {
            return null;
        }

        List<int[]> heights = new ArrayList<>();

        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(buildings.length, (a, b) -> b - a);
        List<List<Integer>> res = new ArrayList<>();

        int prev = 0;
        pq.offer(0);
        for (int[] height : heights) {
            if (height[1] < 0) {
                pq.offer(-height[1]);
            } else {
                pq.remove(height[1]);
            }

            int cur = pq.peek();
            if (prev != cur) {
                res.add(new ArrayList<>(Arrays.asList(height[0], cur)));
                prev = cur;
            }
        }

        return res;
    }

    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());          //  TreeMap< Height, Number of points that have the same height >
        map.put(0,1);
        int prev = 0;

        for (int[] h: heights) {
            if (h[1] < 0) {
                map.put(-h[1], map.getOrDefault(-h[1], 0) + 1);
            } else {
                int cnt = map.get(h[1]);
                if (cnt == 1) {
                    map.remove(h[1]);               //  Removing the key rather than setting the value to 0 to reduce time complexity
                } else {
                    map.put(h[1], cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
