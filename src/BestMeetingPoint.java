package leetcode;

import java.util.ArrayList;
import java.util.List;


public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> Row = new ArrayList<>();
        List<Integer> Col = new ArrayList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    Row.add(i);
                }
            }
        }

        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                if(grid[i][j] == 1){
                    Col.add(j);
                }
            }
        }

        return min(Row) + min(Col);
    }

    private int min(List<Integer> list){
        int i = 0;
        int j = list.size();
        int sum = 0;

        while(i < j){
            sum += list.get(j--) + list.get(i++);
        }
    }
}
