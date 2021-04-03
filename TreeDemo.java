package com.seu.chapter2;

import com.seu.ListNode;

import java.util.*;

public class TreeDemo
{
    static ArrayList<TreeNode> list  = new ArrayList<>();
    static Stack<TreeNode> stack = new Stack<>();
    public static void main(String[] args) {

        TreeNode[] node = new TreeNode[10];
        for(int i=0;i<10;i++){
            node[i]=new TreeNode(i);
        }
        for(int i=0;i<10;i++){
            if(i*2+1<10) node[i].left = node[i*2+1];
            if(i*2+2<10) node[i].right=node[i*2+2];

        }
        ArrayList<TreeNode> list1 = levelOrder(node[0]);
        for(int i=0;i<list1.size();i++){
            System.out.print("\t"+list1.get(i).val);
        }


    }
    //先序遍历，递归实现
    public static ArrayList preOrderRe(TreeNode treeNode){
        if(treeNode!=null) {
            list.add(treeNode);
            preOrderRe(treeNode.left);
            preOrderRe(treeNode.right);
        }
        return list;
    }


    //先序遍历 非递归实现
    public static ArrayList preOrder(TreeNode treeNode){
        while(treeNode!=null || !stack.isEmpty()){
            while(treeNode!=null) {
                list.add(treeNode);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return list;
    }



    // 中序遍历，递归实现
    public static ArrayList midOrderRe(TreeNode treeNode){
        if(treeNode!=null){
            midOrderRe(treeNode.left);
            list.add(treeNode);
            midOrderRe(treeNode.right);

        }
        return list;
    }

   public static ArrayList midOrder(TreeNode treeNode){
        while(treeNode!=null||!stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                list.add(treeNode);
                treeNode = treeNode.right;
            }
        }
        return list;
   }
    //后序遍历递归实现
   public static ArrayList postOrderRe(TreeNode treeNode){
       if(treeNode!=null){
           postOrderRe(treeNode.left);
           postOrderRe(treeNode.right);
           list.add(treeNode);
       }
       return list;
   }
   //后序遍历非递归实现
    public static LinkedList postOrder(TreeNode treeNode){
        LinkedList<TreeNode> llist1 = new LinkedList<>();
        LinkedList<TreeNode> llist2 = new LinkedList<>();
        while(treeNode!=null || !llist1.isEmpty()){
            while(treeNode!=null){
                llist1.addFirst(treeNode);
                llist2.addFirst(treeNode);
                treeNode=treeNode.right;
            }
            if(!llist1.isEmpty()){
                treeNode = llist1.removeFirst();
                treeNode = treeNode.left;
            }
        }

        return llist2;
    }

    //层次遍历
    public static ArrayList levelOrder(TreeNode treeNode){
        ArrayList<TreeNode> list = new ArrayList<>();
        LinkedList<TreeNode> llist = new LinkedList<>();
        if(treeNode!=null){
            llist.addFirst(treeNode);
            while(!llist.isEmpty()){
                treeNode = llist.removeLast();
                list.add(treeNode);
                if(treeNode.left!=null) {
                    llist.addFirst(treeNode.left);
                 //   list.add(treeNode.left);
                }
                if(treeNode.right!=null) {
                    llist.addFirst(treeNode.right);
                }
            }
        }
        return list;
    }

}



class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val =x;
    }
}




//class TreeNode<E>{
//    E val;
//    List<TreeNode> child;
//    public TreeNode(E val){
//         this.val = val;
//    }
//}
