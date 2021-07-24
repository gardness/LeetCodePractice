import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberofIslandsII {

    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();

        int count = 0;
        int[] roots = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            roots[i] = -1;
        }

        for (int[] pair : positions) {
            int position = n * pair[0] + pair[1];
            roots[position] = position;
            count++;

            for (int[] dir : dirs) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];



            }

        }

    }
}
