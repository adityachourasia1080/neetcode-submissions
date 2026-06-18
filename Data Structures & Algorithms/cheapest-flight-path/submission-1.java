class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // cost, node, stops
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], stops = cur[2];

            if (u == dst) return cost;
            if (stops > k) continue;

            for (int[] e : adj.get(u)) {
                int v = e[0], w = e[1];
                if (cost + w < dist[v][stops + 1]) {
                    dist[v][stops + 1] = cost + w;
                    pq.offer(new int[]{cost + w, v, stops + 1});
                }
            }
        }

        return -1;
    }
}
