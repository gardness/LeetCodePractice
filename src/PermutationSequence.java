import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            res.add(i);
        }
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }

        k = k - 1;

        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            k %= fact[i];
            sb.append(res.get(index));
            res.remove(index);
        }

        return sb.toString();
    }
}
