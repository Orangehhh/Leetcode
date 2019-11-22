class Solution {
    class Pair {
        int dst;
        int price;
        Pair(int dst, int price) {
            this.dst = dst;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Pair>[] g = new ArrayList[n];
        buildGraph(g, flights);
        int[][] mem = new int[n][K + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mem[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(1, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        pq.offer(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            if (node[2] > K + 1 || 
               mem[node[1]][node[2]] <= node[0]) continue;
            mem[node[1]][node[2]] = node[0];
            if (node[1] == dst) {
                return node[0];
            }
            for (Pair p : g[node[1]]) {
                pq.offer(new int[]{node[0] + p.price, p.dst, node[2] + 1});
            }
        }
        return -1;
    }
    
    private void buildGraph(List<Pair>[] g, int[][] flights) {
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            g[flight[0]].add(new Pair(flight[1], flight[2]));
        }
    }
}