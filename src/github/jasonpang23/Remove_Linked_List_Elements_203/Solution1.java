package github.jasonpang23.Remove_Linked_List_Elements_203;

public class Solution1 {
    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head ;
        ListNode pre = null ;
        while(cur != null ){
            if(cur.val == val){
                if(pre == null){
                    head = cur.next ;
                    cur = cur.next ;
                }else{
                    pre.next = cur.next ;
                    cur = cur.next  ;
                }
            }else{
                pre = cur ;
                cur = cur.next;
            }
        }
        return head ;
    }
}
