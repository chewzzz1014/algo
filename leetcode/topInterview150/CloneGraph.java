import java.util.ArrayList;
import java.util.List;

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

class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        // old node as key, new node as value
        HashMap<Node, Node> map = new HashMap<>();

        // copy node
        copyNode(node, map);
        // copy edges
        copyNei(node, map, new HashSet<Node>());

        return map.get(node);
    }

    private void copyNode(Node node, HashMap<Node, Node> map) {
        if(map.containsKey(node)) return;
        map.put(node, new Node(node.val, new ArrayList<>()));

        for(Node nei : node.neighbors) {
            copyNode(nei, map);
        }
    }

    private void copyNei(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
        if(visited.contains(node)) return;
        visited.add(node);

        for(Node nei : node.neighbors) {
            map.get(node).neighbors.add(map.get(nei));
            copyNei(nei, map, visited);
        }
    }
}