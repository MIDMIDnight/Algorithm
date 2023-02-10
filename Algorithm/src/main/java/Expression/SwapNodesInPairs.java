package Expression;

import java.util.Stack;

//引用对象存放栈或者集合里面外部引用还是能用的
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> listNodes = new Stack<ListNode>();

        ListNode fast=head;
        ListNode slow=null;

        int falg=0;
        while (true){
            slow=fast;
            fast=fast.next;
            falg++;

            if (falg<3&&fast!=null){
                listNodes.push(slow);
            }
            if (listNodes.size()==2){
                while (falg!=0){
                    ListNode pop1 = listNodes.pop();
                    ListNode pop2 = listNodes.pop();
                    pop1.next=pop2;
                    pop2.next=fast;
                    falg--;
                }
            }
            if (fast==null){
                break;
            }

        }
        return head;
    }
}
