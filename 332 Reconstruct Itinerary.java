class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        buildGraph(g, tickets);
        String src = "JFK";
        List<String> ans = new ArrayList<>();
        dfs(ans, g, src);
        List<String> res = new ArrayList<>();
        for (int i = ans.size() - 1; i >= 0; i--) {
            res.add(ans.get(i));
        }
        return res;
    }
    
    private void dfs(List<String> ans, Map<String, PriorityQueue<String>> g,
                    String loc) {
        PriorityQueue<String> pq = g.get(loc);
        while (pq != null && pq.size() != 0) {
            dfs(ans, g, pq.poll());
        }
        ans.add(loc);
    }
    
    private void buildGraph(Map<String, PriorityQueue<String>> g, 
                            List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if (!g.containsKey(src)) {
                g.put(src, new PriorityQueue<>());
            }
            g.get(src).offer(dst);
        }
    }
}