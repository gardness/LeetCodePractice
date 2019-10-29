import java.util.*;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) {
            return null;
        }

        StringBuilder res = new StringBuilder();
        int[] count = new int[26];
        int[] valid = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNext(count, valid, i);

            if (nextLetter == -1) {
                return "";
            }

            res.append((char)('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;
        }

        return res.toString();
    }

    public int findNext(int[] count, int[] valid, int index) {
        int max = 0;
        int res = -1;

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }

        return res;
    }

    public String rearrangeString2(String s, int k) {
        if (s == null || s.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        pq.addAll(map.entrySet());

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            res.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.add(cur);

            if (queue.size() < k) {
                continue;
            }

            Map.Entry<Character, Integer> tmp = queue.poll();
            if (tmp.getValue() > 0) {
                pq.add(tmp);
            }
        }

        return res.length() == s.length() ? res.toString() : "";
    }
}
