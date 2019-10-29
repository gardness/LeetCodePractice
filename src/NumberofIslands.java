package leetcode;

import java.util.Queue;
import java.util.LinkedList;

public class NumberofIslands {
    private int m;
    private int n;

    public int numIslands(char[][] grid){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0)
            return 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0')
            return;

        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    public int numIslands(char[][] grid){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0)
            return 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        int m = grid.length;
        int n = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);

        while(!queue.isEmpty()){
            code = queue.poll();
            int i = code / m;
            int j = code / n;

            if(i > 0 && grid[i - 1][j] == '1'){
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }

            if(i < grid.length - 1 && grid[i + 1][j] == '1'){
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }

            if(j > 0 && grid[i][j - 1] == '1'){
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }

            if(j < grid[0].length - 1 && grid[i][j + 1] == '1'){
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}
