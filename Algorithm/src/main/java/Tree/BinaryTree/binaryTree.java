package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTree {
    private HeroNode root;

    public binaryTree(HeroNode root) {
        this.root = root;
    }
    public void pre(){
        if (this.root!=null){
            this.root.preList();
        }else {
            System.out.println("二叉树为空");
        }
    }
    public void mid(){

        if (this.root!=null){
            this.root.midList();
        }else {
            System.out.println("二叉树为空");
        }
    }
    public void post(){
        if (this.root!=null){
            this.root.postList();
        }else {
            System.out.println("二叉树为空");
        }
    }
    public List<HeroNode> preTraverseIterateBinaryTree(HeroNode root){
        ArrayList<HeroNode> list=new ArrayList<HeroNode>();
        if (root==null){
            return null;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            HeroNode node = stack.pop();
            list.add(node);
            if (node.getRightNode()!=null){
                stack.push(node.getRightNode());
            }
            if (node.getLeftNode()!=null){
                stack.push(node.getLeftNode());
            }
        }
        return list;
    }
    public List<HeroNode> midTraverseIterateBinaryTree(HeroNode root){
        ArrayList<HeroNode> list=new ArrayList<HeroNode>();
        if (root==null){
            return null;
        }
        Stack<HeroNode> stack=new Stack<HeroNode>();
        HeroNode cur=root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur=cur.getLeftNode();
            }else {
                cur = stack.pop();
                list.add(cur);
                cur=cur.getRightNode();
            }
        }


    return list;
    }
}
