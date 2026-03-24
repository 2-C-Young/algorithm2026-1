//22212022 이시영
package algohw;


class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class HW2 {

	public static void main(String[] args) {
		ListNode head = new ListNode(-1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(-20);
		head.next.next.next.next.next = new ListNode(-100);
		
		Solution2 sol = new Solution2();
		head = sol.insertionSortList(head);
		printList(head);
	}
	public static void printList(ListNode a) {
		while(true) {
			System.out.print(a.val + " ");
			if(a.next == null) break;
			a = a.next;
		}
	}
}

class Solution2 {
	public ListNode insertionSortList(ListNode head) {
		ListNode newlist = new ListNode(0);
		
		ListNode curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			ListNode prev = newlist;
			while(prev.next != null && prev.next.val < curr.val) {
				prev = prev.next;
			}
			curr.next = prev.next;
			prev.next = curr;
			
			curr = next;
			
		}
		return newlist.next;
	 }
}