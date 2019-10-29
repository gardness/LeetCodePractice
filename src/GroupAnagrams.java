import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            String pattern = "";

            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {
                    pattern += String.valueOf(count[i]) + String.valueOf(i + 'a');
                }
            }

            if (map.containsKey(pattern)) {
                map.get(pattern).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(pattern, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
