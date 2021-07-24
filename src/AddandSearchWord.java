public class AddandSearchWord {
    private TrieNode root;

    public AddandSearchWord() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {

        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }

    }
}