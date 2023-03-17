package Tree.PreTree;

public class Trie {
   public TreeNode root=new TreeNode();


   public void insert(String str){
       if (str==null){
           return;
       }
       char[] words = str.toCharArray();
        TreeNode node =root;
        node.pass++;
        int index=0;
       for (int i = 0; i < words.length; i++) {
           index=words[i]-'a';
           if (node.nexts[index]==null){
               node.nexts[index]=new TreeNode();
           }
           node=node.nexts[index];
           node.pass++;
       }
       node.end++;
   }

   public int search(String str){
    if (str==null){
        return 0;
    }
       char[] chars = str.toCharArray();
    int index=0;
       TreeNode treeNode = root;
       for (int i = 0; i < chars.length; i++) {
           index=chars[i]-'a';
           if (treeNode.nexts[index]==null){
               return 0;
           }
           treeNode=treeNode.nexts[index];
       }
       return treeNode.end;
   }


   public void delete(String str){
       if (search(str)!=0){
           char[] chars = str.toCharArray();
           int index=0;
           TreeNode node=root;
           for (int i = 0; i < chars.length; i++) {
               index=chars[i]-'a';
               if (--node.nexts[index].pass==0){
                node.nexts[index]=null;
               }
               node=node.nexts[index];
           }
           node.end--;
       }
   }

   

}
