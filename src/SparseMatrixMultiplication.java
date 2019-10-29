package leetcode;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] fst, int[][] snd){
        int r_f = fst.length;
        int c_f = fst[0].length;
        int c_s = snd[0].length;
        int[][] res = new int[r_f][c_s];

        for(int i = 0; i < r_f; i++){
            for(int j = 0; j < c_f; j++){
                if(fst[i][j] != 0){
                    for(int k = 0; k < c_s; k++){
                        if(snd[j][k] != 0 )
                            res[i][k] += fst[i][j] * snd[j][k];
                    }
                }
            }
        }

        return res;
    }
}
