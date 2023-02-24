package Tree.BinaryTree;

public class IsFullBinaryTree {




    public Info isFull(HeroNode x){
        if (x==null){
            return new Info(0,0);
        }
        Info left=isFull(x.getLeftNode());
        Info right=isFull(x.getRightNode());
        int height=Math.max(left.height, right.height)+1;
        int nodes= left.nodes+right.nodes+1;
        return new Info(height,nodes);




    }



}







class Info{
    int height;
    int nodes;

    public Info(int height, int nodes) {
        this.height = height;
        this.nodes = nodes;
    }
}