package list.method;

import list.Node;

public class LinkedList {
	private Node head;
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public static void main(String[] args) {
		LinkedList llist1 = new LinkedList();
		llist1.setHead(new Node(1));
		Node third = new Node(3);
		Node fifth = new Node(5);
		Node seventh = new Node(7);
		llist1.getHead().setNext(third);
		third.setNext(fifth);
		fifth.setNext(seventh);
		
		LinkedList llist2 = new LinkedList();
		llist2.setHead(new Node(2));
		Node fourth = new Node(4);
		Node sixth = new Node(6);
		Node eigth = new Node(8);
		llist2.getHead().setNext(fourth);
		fourth.setNext(sixth);
		sixth.setNext(eigth);
		
		System.out.print("Before1 : ");
		llist1.printList(llist1.getHead());
		System.out.print("\nBefore2 : ");
		llist2.printList(llist2.getHead());
		
//		System.out.print("\nAfter1  : ");
//		llist1.setHead(reverse(llist1.getHead()));
//		llist1.printList(llist1.getHead());
//		System.out.print("\nAfter2  : ");
//		llist2.setHead(reverse(llist2.getHead()));
//		llist2.printList(llist2.getHead());
		
		System.out.print("\nAfter   : ");
//		solution(llist1.getHead(), llist2.getHead());
		printList(solution(llist1.getHead(), llist2.getHead()));
	}
	
	public static void printList(Node node) {
		Node n = node;
		while (n != null) {
			System.out.print(n.getData() + " ");
			n = n.getNext();
		}
	}
	
	static Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	static Node solution(Node head1, Node head2) {
		Node current = head1;
		Node next = head2;
		Node temp1 = null;
		Node temp2 = null;
		while (current != null) {
			temp1 = current.getNext();
			temp2 = next.getNext();
			current.setNext(next);
			next = temp1;
		}
		return current;
	}
	
	// 1 3 5 7
	// 2 4 6 8
	
//	static void solution(Node head1, Node head2) {
//		System.out.print(head1.getData() + " ");
//		System.out.print(head2.getData() + " ");
//		while (head1.getNext() != null && head2.getNext() != null) {
//			head1 = head1.getNext();
//			head2 = head2.getNext();
//			System.out.print(head1.getData() + " ");
//			System.out.print(head2.getData() + " ");
//		}
//	}
}
