class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode left = null;
        ListNode mid = head;
        ListNode right = head.next;
        while(right != null){
            mid.next = left;
            left = mid;
            mid = right;
            right = right.next;
        }
        mid.next = left;
        head = mid;
        return head;
    }
}