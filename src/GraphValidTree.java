import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {
            return true;
        }

        if (n < 1 || edges == null || edges.length != n - 1) {
            return false;
        }

        int[] roots = new int[n];

        for (int i = 0; i < n; i++) {
            roots[i] = -1;
        }

        for (int[] edge : edges) {
            int x = find(roots, edge[0]);
            int y = find(roots, edge[1]);

            if (x == y) {
                return false;
            }

            roots[x] = y;
        }

        return true;
    }

    public int find(int[] roots, int idx) {
        while (roots[idx] != -1) {
            idx = roots[idx];
        }

        return idx;
    }


    public boolean validTree2(int n, int[][] edges) {
        List<List<Integer>> graph = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][1]).add(edges[i][0]);
            graph.get(edges[i][0]).add(edges[i][1]);
        }

        HashSet<Integer> visited = new HashSet<>();

        visited.add(0);

        boolean res = DFS(graph, visited, 0, -1);

        if (res == false) {
            return false;
        }

        return visited.size() == n ? true : false;
    }

    public boolean DFS(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
        List<Integer> adjacentList = graph.get(node);

        for (int v : adjacentList) {
            if (v == parent) {
                continue;
            }

            if (visited.contains(v)) {
                return false;
            }

            visited.add(v);

            boolean res = DFS(graph, visited, v, node);

            if (res == false) {
                return false;
            }
        }

        return true;
    }


}
