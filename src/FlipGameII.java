import java.util.HashMap;

public class FlipGameII {

    public boolean canWin(String s) {
        HashMap<String, Boolean> map = new HashMap<>();

        return helper(s, map);
    }

    public boolean helper(String s, HashMap<String, Boolean> map) {

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String opponent = s.substring(0, i) + "--" + s.substring(i + 2, s.length());

                if (!helper(opponent, map)) {
                    map.put(s, true);

                    return true;
                }
            }
        }

        map.put(s, false);

        return false;
    }
}