package github.jasonpang23.Remove_Linked_List_Elements_203;

public class Solution3 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeElements(ListNode head, int val){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head ;

        ListNode pre = dummyNode ;
        while(pre.next != null){
            if(pre.next.val == val)
                pre.next = pre.next.next;
            else
                pre = pre.next;
        }

        return dummyNode.next;
    }
}
