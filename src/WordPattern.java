import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
       String[] arr = str.split(" ");

       if (pattern.length() != arr.length) {
           return false;
       }

       HashMap<Character, String> map = new HashMap<>();

       for (int i = 0; i < pattern.length(); i++) {
           char ch = pattern.charAt(i);

           if (!map.containsKey(ch)) {
               if (map.get(ch).equals(arr[i])) {
                   continue;
               } else {
                   return false;
               }
           } else {
               if (map.containsValue(arr[i])) {
                   return false;
               } else {
                   map.put(ch, arr[i]);
               }
           }
       }

       return true;
    }
}
