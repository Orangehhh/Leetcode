/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }
    
    private void dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return;
        }
        Node mappedNode = new Node(node.val, new ArrayList<>());
        map.put(node, mappedNode);
        for (Node n : node.neighbors) {
            dfs(n, map);
            mappedNode.neighbors.add(map.get(n));
        }
    }
}