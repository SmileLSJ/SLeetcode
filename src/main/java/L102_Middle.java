import java.util.*;

/**
 * Created by smile on 2019/6/15.
 */
public class L102_Middle {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root==null) return null;

        Deque  queue =  new ArrayDeque();
        TreeNode node  = root;
        queue.push(node);

        List<List<Integer>> result  = new ArrayList<>();
        while(!queue.isEmpty()){

            List<Integer> list  = new ArrayList<>();
            int size = queue.size();

            for(int i= 0;i<size;i++){
                TreeNode temp = (TreeNode) queue.poll();
                list.add(temp.val);
                if(temp.left!=null) {
                    queue.offer(temp.left);
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                }
            }
            result.add(list);
        }
        return  result;

    }





     public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
