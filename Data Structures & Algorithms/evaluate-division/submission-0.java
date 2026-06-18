class Solution {
    public double[] calcEquation(List<List<String>> equations, 
                                  double[] values, 
                                  List<List<String>> queries) {

        HashMap<String, List<Object[]>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double w = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Object[]{v, w});
            graph.get(v).add(new Object[]{u, 1.0 / w}); // reverse edge
        }

        double[] ans = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end   = queries.get(i).get(1);

            // Node doesn't exist in graph at all
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }

            // BFS
            ans[i] = bfs(graph, start, end);
        }

        return ans;
    }

    private double bfs(HashMap<String, List<Object[]>> graph, 
                       String start, String end) {

        if (start.equals(end)) return 1.0;

        Queue<Object[]> queue = new LinkedList<>(); // {node, product}
        HashSet<String> visited = new HashSet<>();

        queue.add(new Object[]{start, 1.0});
        visited.add(start);

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();
            String node  = (String) curr[0];
            double prod  = (double) curr[1];

            for (Object[] neighbor : graph.get(node)) {
                String next = (String) neighbor[0];
                double w    = (double) neighbor[1];

                if (next.equals(end)) return prod * w;

                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(new Object[]{next, prod * w});
                }
            }
        }
        return -1.0;
    }
}