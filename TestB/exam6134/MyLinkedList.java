package com.ssafy.git.TestB.exam6134;

public class MyLinkedList {
	// First Node Data & Last Node data & size
	Node head; Node tail; int size;
	int modValue = 2003;
		
	public MyLinkedList() {
		super();
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.modValue = 2003;
	}
	//node data = (HashIndex, stringData)
	public class Node{
		int HashIdx; String data;
		Node next; Node prev;

		public Node(int HashIdx, String data) {
			super();
			this.HashIdx = HashIdx;
			this.data = data;
			this.next = null;
			this.prev = null;
		}	
	}
	
	// GET part
	public Node getIndexNode(int idx) {
		Node x = head;
		for(int i=0;i<idx;i++) {
			x = x.next;
		}
		return x;
	}
	public Node getStringNode(String str) {
		Node x = head;
		while(!isEqualContent(x, str)) {
			x = x.next;
			if(x == null) {
				return null;
			}
		}
		return x;
	}
	public boolean isEqualContent(Node a, String s) {
		if(a.HashIdx == hash(s)) {
			for(int i=0;i<a.data.length();i++) {
				if(a.data.charAt(i) != s.charAt(i)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public int hash(Node n) {
		int hashValue = 0;
		for(int i=0;i<n.data.length(); i++) {
			hashValue = mod(hashValue + n.data.charAt(i));
		}
		return hashValue;
	}
	public int hash(String s) {
		int hashValue = 0;
		for(int i=0;i<s.length(); i++) {
			hashValue = mod(hashValue + s.charAt(i));
		}
		return hashValue;
	}
	public int mod(int num) {
		return num % modValue;
	}
	
	// ADD part
	public void add(int idx, Node x) {
		if(idx == 0) {
			// 첫번째 삽입
			addFirst(x);
		} else {
			// t1: idx 이전의 노드
			Node t1 = getIndexNode(idx - 1);
			// t2: t1의 다음 노드, 현재 idx의 노드
			Node t2 = t1.next;
			// 근데 t2가 null? => 끝에다가 add된 거임
			if(t2 == null) {
				addLast(x);
			} else {
				// t1과 x를 연결
				t1.next = x;
				x.prev = t1;
				// x와 t2를 연결
				x.next = t2;
				t2.prev = x;
				// 추가 후 tail 확인 및 갱신
				size++;
			}
		}
	}
	public void addFirst(Node x) {
		x.next = head;
		head = x;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	public void addLast(Node x) {
		if(size == 0) {
			addFirst(x);
		} else {
			tail.next = x;
			x.prev = tail;
			tail = x;
			size++;
		}
	}
	
	// DEL part
	public void del(int idx) {
		if(idx == 0) {
			delFirst();
		} else {
			// beforeNode: idx 이전 노드
			Node beforeNode = getIndexNode(idx - 1);
			// deleteNode: beforeNode의 다음노드, idx 노드, 곧 삭제될 노드
			Node deleteNode = beforeNode.next;
			// beforeNode와 deleteNode 연결 끊기
			beforeNode.next = deleteNode.next;
			deleteNode.next.prev = beforeNode;
			// 이후 tail 확인
			if(deleteNode == tail) {
				tail = beforeNode;
			}
			deleteNode = null;
		}
	}
	public void delFirst() {
		Node delNode = head;
		head = delNode.next;
		delNode = null;
		size--;
	}
	public void delLast() {
		del(size-1);
	}
}
