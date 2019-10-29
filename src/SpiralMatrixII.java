import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int cnt = 1;
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = cnt++;
            }
            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = cnt++;
            }
            colEnd--;

            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = cnt++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = cnt++;
            }
            colBegin++;
        }

        return matrix;
    }
}
