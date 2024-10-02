/**
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced
binary search tree.

 

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

 

Constraints:

    1 <= nums.length <= 104
    -104 <= nums[i] <= 104
    nums is sorted in a strictly increasing order.


**/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode();
        if(nums.length == 1){
            treeNode.val = nums[0];
            return treeNode;
        }
        if(nums.length == 2){
            treeNode.val = nums[0];
            treeNode.right = new TreeNode(nums[1]);
            return treeNode;
        }
        boolean odd = nums.length % 2 == 1 ? true : false;
        int[] left, right;
        int substringRange;
        int substringRangeDos;
        
        if(odd){
            substringRange = nums.length / 2;
        }else{
            substringRange = (nums.length / 2) - 1;
        }

        treeNode.val = nums[substringRange];
        left = Arrays.copyOfRange(nums, 0, substringRange);
        right = Arrays.copyOfRange(nums, substringRange + 1, nums.length);
        treeNode.left = sortedArrayToBST(left);
        treeNode.right = sortedArrayToBST(right);
        return treeNode;
    }
}
