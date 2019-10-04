package com.ssafy.git.TestB.exam6134;

class UserSolution {
	static int index = 0;
	static final int modValue = 2003;
	static recordTable RT;
	static fieldTable[] FTList;
	
	static class node{
		int HashIdx; String s;
		node next; node prev;

		public node(int HashIdx, String s) {
			super();
			this.HashIdx = HashIdx;
			this.s = s;
			this.next = null;
			this.prev = null;
		}
	}
	
	static class nodeList{
		node head; node tail; int size;
		public nodeList() {
			this.head = null;
			this.tail = null;
			this.size = 0;
		}
		public node getIndexNode(int idx) {
			node x = head;
			for(int i=0;i<idx;i++) {
				x = x.next;
			}
			return x;
		}
		public int hash(node x) {
			int hashValue = 0;
			for(int i=0;i<x.s.length(); i++) {
				hashValue = mod(hashValue + x.s.charAt(i));
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
		
		public void add(int idx, node x) {
			if(idx == 0) {
				addFirst(x);
			} else {
				node t1 = getIndexNode(idx - 1);
				node t2 = t1.next;
				if(t2 == null) {
					addLast(x);
				} else {
					t1.next = x;
					x.prev = t1;
					x.next = t2;
					t2.prev = x;
					size++;
				}
			}
		}
		public void addFirst(node x) {
			x.next = head;
			head = x;
			size++;
			if(head.next == null) {
				tail = head;
			}
		}
		public void addLast(node x) {
			if(size == 0) {
				addFirst(x);
			}else {
				tail.next = x;
				x.prev = tail;
				tail = x;
				size++;
			}
		}
		
		public void del(int idx) {
			if(idx == 0) {
				delFirst();
			}else {
				node t1 = getIndexNode(idx - 1);
				node t2 = t1.next;
				t1.next = t2.next;
				if(t2.next == null) {
					tail = t1;
				} else {
					t2.next.prev = t1;
				}
				t2 = null;
				size--;
			}
		}
		public void delFirst() {
			node delNode = head;
			head = delNode.next;
			delNode =  null;
			size--;
		}
	}
	static class recordTable{
		node[][] table = new node[50001][5];

		public recordTable() {
			// TODO Auto-generated constructor stub
		}
		void add(node name, node num, node birth, node email, node memo) {
			table[index][0] = name;
			table[index][1] = num;
			table[index][2] = birth;
			table[index][3] = email;
			table[index][4] = memo;
		}
	}
	static class fieldTable{
		nodeList[] list;

		public fieldTable() {
			list = new nodeList[modValue];
			for(int i=0;i<modValue;i++) {
				list[i] = new nodeList();
			}
		}
		int mod(int num) {
			return num % modValue;
		}
		int hash(node n) {
			int hashValue = 0;
			for(int i=0;i<n.s.length();i++) {
				hashValue = mod(hashValue + n.s.charAt(i));
			}
			return hashValue;
		}
		void init() {
			for(int i=0;i<modValue;i++) {
				list[i].size = 0;
			}
		}
		void add(node n) {
			list[hash(n)].addLast(n);
		}
		void delete(String s, int idx) {
			int hashValue = hash(new node(-1,s));
//			BreakPoint:
//				for(int i=0;i<list[hashValue].size; i++) {
//					if(s.length() == list[hashValue].getIndexNode(i).s.length() && 
//						idx == list[hashValue].getIndexNode(i).HashIdx) {
//						for(int j=0;j<s.length();j++) {
//							if(s.charAt(j) != list[hashValue].getIndexNode(i).s.charAt(j)) {
//								continue BreakPoint;
//							}
//						}
//						list[hashValue].del(i);
//						i--;
//					}
//				}
			
			nodeList nl = list[hashValue]; node p = nl.head;
			while(p != null) {
				boolean find = true;
				if(s.length() == p.s.length() && idx == p.HashIdx) {
					for(int j=0;j<s.length();j++) {
						if(s.charAt(j) != p.s.charAt(j)) {
							find = false;
							break;
						}
					}
				} else {
					find = false;
				}
				if(find) {
					if(p.prev != null)
						p.prev.next = p.next;
					if(p.next != null)
						p.next.prev = p.prev;
					nl.size--;
				}
				p = p.next;
			}
			
		}
		void change(int idx, String s, node n) {
			int hashValue = hash(new node(-1,s));
//			BreakPoint:
//				for(int i=0;i<list[hashValue].size; i++) {
//					if(s.length() == list[hashValue].getIndexNode(i).s.length() && 
//						idx == list[hashValue].getIndexNode(i).HashIdx) {
//						for(int j=0;j<s.length();j++) {
//							if(s.charAt(j) != list[hashValue].getIndexNode(i).s.charAt(j)) {
//								continue BreakPoint;
//							}
//						}
//						list[hashValue].del(i);
//						list[hash(n)].addLast(n);
//						return;
//					}
//				}
			
			nodeList nl = list[hashValue]; node p = nl.head;
			while(p != null) {
				boolean find = true;
				if(s.length() == p.s.length() && idx == p.HashIdx) {
					for(int j=0;j<s.length();j++) {
						if(s.charAt(j) != p.s.charAt(j)) {
							find = false;
							break;
						}
					}
				} else {
					find = false;
				}
				if(find) {
					p.s = n.s;
					p.HashIdx = n.HashIdx;
				}
				p = p.next;
			}
		}
		nodeList getList(String s) {
			nodeList ret = new nodeList();
			int hashValue = hash(new node(-1,s));
			//System.out.println(hashValue);
//			BreakPoint:
//				for(int i=0;i<list[hashValue].size; i++) {
//					if(s.length() == list[hashValue].getIndexNode(i).s.length()) {
//						for(int j=0;j<s.length();j++) {
//							if(s.charAt(j) != list[hashValue].getIndexNode(i).s.charAt(j)) {
//								continue BreakPoint;
//							}
//						}
//						ret.addLast( new node(list[hashValue].getIndexNode(i).HashIdx,
//								list[hashValue].getIndexNode(i).s));
//					}
//				}
			nodeList nl = list[hashValue]; node p = nl.head;
			while(p != null) {
				boolean find = true;
				if(s.length() == p.s.length()) {
					for(int j=0;j<s.length();j++) {
						if(s.charAt(j) != p.s.charAt(j)) {
							find = false;
							break;
						}
					}
				} else {
					find = false;
				}
				if(find) {
					ret.addLast(new node(p.HashIdx, p.s));
				}
				p = p.next;
			}
			return ret;
		}
	}
	
	void InitDB()
	{
		index = 0;
		if(FTList == null) {
			RT = new recordTable();
			FTList = new fieldTable[5];
			for(int i=0;i<5;i++) {
				FTList[i] = new fieldTable();
			}
		} else {
			for(int i=0;i<5;i++) {
				FTList[i] = new fieldTable();
			}
		}
	}

	void Add(String name, String number, String birthday, String email, String memo)
	{
		node nodeName = new node(index, name);
		node nodeNumber = new node(index, number);
		node nodeBirth = new node(index, birthday);
		node nodeEmail = new node(index, email);
		node nodeMemo = new node(index, memo);
		
		RT.add(nodeName, nodeNumber, nodeBirth, nodeEmail, nodeMemo);
		FTList[0].add(nodeName);
		FTList[1].add(nodeNumber);
		FTList[2].add(nodeBirth);
		FTList[3].add(nodeEmail);
		FTList[4].add(nodeMemo);
		
		index++;
	}

	int Delete(int field, String str)
	{
		nodeList ret = FTList[field].getList(str); node rp = ret.head;
		while(rp!=null) {
			int num = rp.HashIdx;
			for(int j=0;j<5;j++) {
				FTList[j].delete(RT.table[num][j].s, RT.table[num][j].HashIdx);
			}
			rp = rp.next;
		}
//		for(int i=0;i<ret.size; i++) {
//			int num = ret.getIndexNode(i).HashIdx;
//			for(int j=0;j<5;j++) {
//				FTList[j].delete(RT.table[num][j].s, RT.table[num][j].HashIdx);
//			}
//		}
		return ret.size;
	}

	int Change(int field, String str, int changefield, String changestr)
	{
		nodeList ret = FTList[field].getList(str); node rp = ret.head;
		while(rp!=null) {
			int num = rp.HashIdx;
			node n = new node(num, changestr);
			FTList[changefield].change(num, RT.table[num][changefield].s, n);
			RT.table[num][changefield] = n;
			rp = rp.next;
		}
//		for(int i=0;i<ret.size;i++) {
//			int num = ret.getIndexNode(i).HashIdx;
//			node n = new node(num, changestr);
//			FTList[changefield].change(num, RT.table[num][changefield].s, n);
//			RT.table[num][changefield] = n;
//		}
		return ret.size;
	}

	Solution.Result Search(int field, String str, int returnfield)
	{
		nodeList ret = FTList[field].getList(str);
		Solution.Result result = new Solution.Result();
		result.count = ret.size;
		if(result.count == 1) {
			result.str = RT.table[ret.getIndexNode(0).HashIdx][returnfield].s;
		}else {
			result.str = "";
		}
		return result;
	}
}