public class BombEnemy {
    public int maxKilledEnemies(char[][] grid){
        if(grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        int m = grid.length;
        int n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];
        int res = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0 || grid[i][j - 1] == 'W'){
                    rowCount = 0;

                    for(int k = j; k < n && grid[i][j] != 'W'; k++){
                        rowCount += (grid[i][k] == 'E' ? 1 : 0);
                    }
                }

                if(i == 0 || grid[i - 1][j] == 'W'){
                    colCount[j] = 0;

                    for(int k = i; k < m && grid[i][j] != 'W'; k++){
                        colCount[j] = (grid[k][j] == 'E' ? 1 : 0);
                    }
                }

                if(grid[i][j] == '0'){
                    res = Math.max(res, colCount[j] + rowCount);
                }
            }
        }

        return res;
    }
}
