import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length() + "\\" + str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int index = s.indexOf("\\", i);
            int size = Integer.valueOf(s.substring(i, index));

            res.add(s.substring(index + 1,  index + size + 1));
            i = index + size + 1;
        }

        return res;
    }
}
