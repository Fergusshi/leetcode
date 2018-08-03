/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max = -1;
    int themaxleft = 0;
    public int findBottomLeftValue(TreeNode root) {

        this.posOrder(root,0);
        return this.themaxleft;
        
    }       

    
    public void posOrder(TreeNode node, int height){
        if (node != null)
        {
            if(height>this.max){
                this.max = height;
                this.themaxleft = node.val;
            }
            posOrder(node.left, height+1);
            posOrder(node.right,height+1);

        }
    }
        
}
