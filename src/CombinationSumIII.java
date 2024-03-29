import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < 10; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
