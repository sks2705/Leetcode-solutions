import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        int n = online.length;
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxCost = 0;
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            maxCost = Math.max(maxCost, e[2]);
        }

        int low = 0, high = maxCost;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, graph, edges, online, k, n)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int minEdge,
                          List<int[]>[] graph,
                          int[][] edges,
                          boolean[] online,
                          long k,
                          int n) {

        int[] indegree = new int[n];

        // Build indegree only for usable edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            if (w < minEdge)
                continue;

            if (v != n - 1 && !online[v])
                continue;

            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        while (!q.isEmpty()) {

            int u = q.poll();

            for (int[] nxt : graph[u]) {

                int v = nxt[0];
                int w = nxt[1];

                if (w < minEdge)
                    continue;

                if (v != n - 1 && !online[v])
                    continue;

                if (dist[u] != INF) {
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }

                indegree[v]--;
                if (indegree[v] == 0)
                    q.offer(v);
            }
        }

        return dist[n - 1] <= k;
    }
}