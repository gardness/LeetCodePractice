public class UniquePaths {
    public int uniquePaths(int m, int n){
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            res[i][0] = 1;
        }

        for(int j = 0; j < n; j++){
            res[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }

        return res[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n){
        int[] res = new int[n];

        res[0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                res[j] = res[j] + res[j - 1];
            }
        }

        return res[n - 1];
    }

    public int uniquePaths3(int m, int n){
        int count = m + n - 2;
        int k = m - 1;
        double res = 1;

        for(int i = 1; i <= k; i++){
            res = res * (count - k + i) / i;
        }

        return (int) res;
    }
}
