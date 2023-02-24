package Tree.BinaryTree;

import java.util.HashMap;
import java.util.HashSet;

public class LowerCommomAncient {

    public HeroNode getLCA(HeroNode head,HeroNode o1,HeroNode o2){
        HeroNode lca = null;
        HashMap<HeroNode, HeroNode> fatherMap = new HashMap<>();
        fatherMap.put(head,head);
        process(head,fatherMap);
        HashSet<HeroNode> heroNodes = new HashSet<>();
        heroNodes.add(o1);
        HeroNode cur=o1;
        while (cur!=fatherMap.get(cur)){
            heroNodes.add(cur);
            cur=fatherMap.get(cur);
        }
        cur=o2;
        while (cur!=fatherMap.get(cur)){
            boolean contains = heroNodes.contains(cur);
            if (contains){
                lca=cur;
            }
            cur=fatherMap.get(cur);
        }
        return lca;

    }

    public void process(HeroNode head, HashMap<HeroNode,HeroNode> fatherMap){
        if (head==null){
            return;
        }
        fatherMap.put(head.getLeftNode(),head);
        fatherMap.put(head.getRightNode(),head);
        process(head.getLeftNode(),fatherMap);
        process(head,fatherMap);
    }


}
