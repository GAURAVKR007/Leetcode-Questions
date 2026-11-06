import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    public int dfs(Node root, int curr, int res) {
        if (root == null) {
            return 0;
        }

        for (Node neighbor : root.children) {
            res = dfs(neighbor, curr + 1, res);
        }

        return Math.max(res, curr);

    }

    public int maxDepth(Node root) {
        int res = 0;

        res = dfs(root, 0, res);

        return res + 1;
    }
}

public class MaxDepthNArray {
    public static void main(String[] args) {
        Node root = new Node(1, Arrays.asList(
                new Node(3, Arrays.asList(
                        new Node(5),
                        new Node(6))),
                new Node(2),
                new Node(4)));

        Solution solution = new Solution();

        int result = solution.maxDepth(root);

        System.out.println("Maximum Depth: " + result);
    }
}