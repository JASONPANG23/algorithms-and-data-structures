package github.jasonpang23.Remove_Linked_List_Elements_203;

public class Solution4 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        public ListNode(int[]arr){
            ListNode cur = this ;
            val = arr[0] ;
            for (int i = 1; i < arr.length; i++) {
                ListNode node = new ListNode(arr[i]) ;
                cur.next = node ;
                cur = cur.next ;
            }

        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }


    public ListNode removeElements(ListNode head, int val,int depth) {
        if(head == null)
            return null ;

        String stringDepth = depthString(depth) ;
        System.out.print("Call ");
        System.out.print(stringDepth+head.val+" + ");
        System.out.print("[");
        for (ListNode node = head.next;node != null ;node = node.next){
            System.out.print(node);
            if(node.next != null){
                System.out.print(",");
            }
        }
        System.out.println("]");

        head.next = removeElements(head.next,val,depth+1) ;

        System.out.print("Back ");
        System.out.print(stringDepth);
        System.out.print("[");
        ListNode result = null;
        if(head.val == val){
            result = head.next;
        }else{
            result = head ;
        }
        for (ListNode node = result;node != null ;node = node.next){
            System.out.print(node);
            if(node.next != null){
                System.out.print(",");
            }
        }
        System.out.println("]");
        return result ;

    }
    private String depthString(int depth){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString() ;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7} ;
        ListNode node = new ListNode(arr) ;
        Solution4 solution4 = new Solution4() ;
        solution4.removeElements(node,3,0) ;

    }
}
