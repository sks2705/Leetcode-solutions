import java.util.*;

class Pair {

    long first;
    long second;

    Pair(long first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int countPaths(int n, int[][] roads) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int w = road[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) -> Long.compare(a.first, b.first));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            long dis = current.first;
            int node = (int) current.second;

            for (Pair it : adj.get(node)) {

                int adjNode = (int) it.first;
                long edgeWeight = it.second;

                if (dis + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = dis + edgeWeight;

                    ways[adjNode] = ways[node];

                    pq.offer(new Pair(dist[adjNode],adjNode));
                }

                else if (dis + edgeWeight == dist[adjNode]) {

                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1];
    }
}