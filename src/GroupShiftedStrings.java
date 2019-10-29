import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strings) {
            String key = "";
            int offset = str.charAt(0) - 'a';

            for (int i = 0; i < str.length(); i++) {
                char ch = (char) (str.charAt(i) - offset);

                if (ch < 'a') {
                    ch += 26;
                }

                key += ch;
            }

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>(Arrays.asList(str));
                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }


}
