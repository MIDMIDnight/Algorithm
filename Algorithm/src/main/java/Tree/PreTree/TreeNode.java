package Tree.PreTree;

public class TreeNode {
    public int pass;
    public int end;
    public TreeNode[] nexts;//HashMap<char,Node> nexts;

    public TreeNode(){
        pass=0;
        end=0;
        nexts=new TreeNode[26];
    }

}
