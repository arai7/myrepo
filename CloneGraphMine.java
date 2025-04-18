/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node, Node> clonedMap = new HashMap<>();
        return dfs(node, clonedMap);
    }

    private Node dfs(Node node, Map<Node, Node> clonedMap){
        if(clonedMap.containsKey(node)){
            return clonedMap.get(node);
        }

        Node clonedNode = new Node(node.val);
        clonedMap.put(node, clonedNode);
        
        for(Node oneN : node.neighbors){
            Node clonedNeighbor = dfs(oneN, clonedMap);
            clonedNode.neighbors.add(clonedNeighbor);
        }

        return clonedNode;
    }
}
