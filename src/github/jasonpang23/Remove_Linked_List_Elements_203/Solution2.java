package github.jasonpang23.Remove_Linked_List_Elements_203;

public class Solution2 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode removeElements(ListNode head, int val) {
        //循环删除头结点
        while(head != null && head.val == val)
            head = head.next ;

        if(head == null)
            return head;

        //剩余的结点中，头结点不是要删除的结点

        ListNode pre = head ;
        while(pre.next != null){
            if(pre.next.val == val)
                pre.next = pre.next.next ;
            else
                pre = pre.next ;
        }
        return head;
    }
}
