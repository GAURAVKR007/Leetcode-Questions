import java.util.ArrayList;
import java.util.List;

class SumRootToLeaf {
    public static List<String> list = new ArrayList<>();
    public static void dfs(TreeNode root, String str){
        if(root == null){
            return;
        }

        str = str + Integer.toString(root.val);

        if(root.left == null && root.right == null){
            list.add(str);
            return;
        }

        if(root.left != null){
            dfs(root.left,str);
        }

        if(root.right != null){
            dfs(root.right,str);
        }
    }
    public static int sumNumbers(TreeNode root) {
        dfs(root,"");

        int res = 0;

        for(String s : list){
            int num = Integer.parseInt(s);

            res = res + num;
        }

        return res;
    }
    public static void main(String[] args) {
        // root = [4,9,0,5,1]
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
    }
}
