public class ShortestWordDistance {

    //  time : O(n^2)  space : O(1)
    public int shortestDistance(String[] words, String word1, String word2) {
        int res = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }

        return res;
    }

    //  time : O(n)  space : O(1)
    public int shortestDistance2(String[] words, String word1, String word2) {
        int pos1 = -1;
        int pos2 = -1;
        int res = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            } else if (words[i].equals(word2)) {
                pos2 = i;
            }

            if (pos1 != -1 && pos2 != -1) {
                res = Math.min(res, Math.abs(pos1 - pos2));
            }
        }

        return res;
    }

}
