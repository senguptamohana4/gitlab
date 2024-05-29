package com.assignments;


public class RemoveDuplicatesFromSortedList {
	
		public ListNode deleteDuplicates(ListNode head) {
			if(head == null || head.next == null) {
				return head;
			}
			
			ListNode current = head;
			
			while(current != null && current.next != null) {
				if(current.val == current.next.val) {
					current.next = current.next.next;
					
				} else {
					current = current.next;
				}
			}
			return head;
			
		}
		public static void printList(ListNode head) {
			ListNode current = head;
			while(current != null) {
				System.out.println(current.val + " -> ");
				current = current.next;
			}
			System.out.println("null");
			
		}
		public static void main(String args[]) {
			ListNode head = new ListNode(1);
			head.next = new ListNode(1);
			head.next.next = new ListNode(2);
			head.next.next.next = new ListNode(3);
			head.next.next.next.next = new ListNode(3);
			
			System.out.println("Original list: ");
			printList(head);
			
			RemoveDuplicatesFromSortedList solution = new RemoveDuplicatesFromSortedList();
			ListNode newHead = solution.deleteDuplicates(head);
			
			System.out.println("List after removing duplicated: ");
			printList(newHead);
		}
	}


