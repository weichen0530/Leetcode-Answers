// if there are 2 middle node, return second one
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

// if there are 2 middle node, return first one
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
			if(fast.next != null)
				slow = slow.next;
        }
        return slow;
    }
}