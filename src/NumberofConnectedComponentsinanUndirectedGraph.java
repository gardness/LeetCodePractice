public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        int cnt = 0;

        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);

            if (x != y) {
                cnt++;
                roots[x] = y;
            }
        }

        return n - cnt;
    }

    public int find(int[] roots, int idx) {
        while (roots[idx] != -1) {
            idx = roots[idx];
        }

        return idx;
    }
}
