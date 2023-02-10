package Expression;
//206


public class reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head==null){
            return null;
        }
        if (head.next==null){
            return head;
        }
        ListNode cur=null;
        ListNode pre=null;
        while (head!=null){
            cur=head.next;
            head.next=pre;
            pre=head;
            head=cur;

        }

    return pre;
    }

}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }