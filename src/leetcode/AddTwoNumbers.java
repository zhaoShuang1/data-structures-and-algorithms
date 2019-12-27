package leetcode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null)
			return null;
		
		ListNode temp = new ListNode(-1);
		ListNode currentNode = temp;
		int carry = 0;
		
		while(l1 != null || l2 != null) {
			int l1v = l1==null?0:l1.val;
			int l2v = l2==null?0:l2.val;
			int s = l1v+l2v+carry;
			carry = s/10;
			currentNode = currentNode.next = new ListNode(s%10);
			l1 = l1 == null?null:l1.next;
			l2 = l2 == null?null:l2.next;
		}
		if(carry > 0) {
			currentNode.next = new ListNode(carry);
		}
		return temp.next;
	}


	
	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		
		
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode addTwoNumbers2 = addTwoNumbers.addTwoNumbers(l1, l2);
		System.out.println(addTwoNumbers2);
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
