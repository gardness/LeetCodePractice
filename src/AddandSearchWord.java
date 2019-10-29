package leetcode;


class TrieNode{
    TrieNode[] children;
    boolean isWord;
    String word;

    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
        word = "";
    }
}

public class AddandSearchWord {
    private TrieNode root;

    public AddandSearchWord(){
        root = new TrieNode();
    }

    public void addword(String word){
        TrieNode node = root;

        for(int i = 0; i < word.length(); i++){
            int j = word.charAt(i) - 'a';

            if(node.children[j] == null){
                node.children[j] = new TrieNode[];
            }

            node = node.children[j];
        }

        node.isWord = true;

    }

    public boolean search(String word){
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index){
        if(index == word.length())
            return node.isWord;

        if(word.charAt(index) == '.'){
            for(TrieNode tmp : node.children){
                if(tmp != null && find(word, tmp, index + 1)){
                    return true;
                }
            }

            return false;
        }else{
            int i = word.charAt(index) - 'a';
            TrieNode tmp = node.children[i];

            return tmp != null && find(word, tmp, index + 1);
        }
    }
}
