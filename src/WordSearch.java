public class WordSearch {
    public boolean exist(char[][] board, String word){
        if(board == null || board.length == 0 || board[0] == null || board[0].length == 0)
            return false;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, word, 0)){
                    return true;
                }
            }
        }
    }

    private boolean exist(char[][] board, int i, int j, String word, int start){
        if(start >= word.length())
            return true;

        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if(board[i][j] == word.charAt(start++)){
            char ch = board[i][j];
            board[i][j] = '#';
            boolean res = exist(board, i + 1, j, word, start) ||
                    exist(board, i - 1, j, word, start) ||
                    exist(board, i, j + 1, word, start) ||
                    exist(board, i, j - 1, word, start);

            board[i][j] = ch;

            return res;
        }

        return false;
    }
}