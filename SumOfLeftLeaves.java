class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SumOfLeftLeaves {

    public static int res = 0;
    public static boolean flag = false;

    // 👉 YOUR FUNCTION (keep it as you wrote for debugging)
    public void dfs(TreeNode curr) {
        if (curr == null) {
            return;
        }

        if (curr.left == null && curr.right == null && flag == false) {
            res = res + curr.val;
        }

        if (curr.left != null) {
            flag = false;
            dfs(curr.left);
        }

        if (curr.right != null) {
            flag = true;
            dfs(curr.right);
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        // Run your function
        SumOfLeftLeaves obj = new SumOfLeftLeaves();
        int result = obj.sumOfLeftLeaves(root);

        System.out.println("Result: " + result); // expected = 24
    }
}