class Solution {
    private int[] dirs = new int[] {-1, 0, 1, 0, -1};
    private final long M = 1000001L;
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blocks = new HashSet<>();
        for (int[] b : blocked) {
            blocks.add(b[0] * M + b[1]);
        }
        return dfs(blocks, source, target, source, new HashSet<>()) && 
            dfs(blocks, target, source, target, new HashSet<>());
    }
    
    private boolean dfs(Set<Long> blocks, int[] source, 
                       int[] target, int[] cur, Set<Long> visited) {
        if (cur[0] == target[0] && cur[1] == target[1])   return true;
        if (Math.abs(source[0] - cur[0]) + Math.abs(source[1] - cur[1]) > 200)  return true;
        visited.add(cur[0] * M + cur[1]);
        for (int k = 0; k < 4; k++) {
            int r = cur[0] + dirs[k];
            int c = cur[1] + dirs[k + 1];
            long l = r * M + c;
            if (r < 0 || r >= 1000000 || c < 0 || c >= 1000000 ||
               blocks.contains(l) || visited.contains(l))    continue;
            if (dfs(blocks, source, target, new int[]{r, c}, visited)) {
                return true;
            }
        }
        return false;
    }
}