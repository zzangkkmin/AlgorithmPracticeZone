package com.ssafy.git.TestB.exam6134;

class UserSolution {
	static int index = 0;
	static final int modValue = 2003;
	static recordTable RT;
	static fieldTable[] FTList;
	
	static class node{
		String s;
		int idx;
		node prev;
		node next;
		public node(String s, int idx) {
			this.s = s;
			this.idx = idx;
		}
		public node(String s) {
			this.s = s;
		}
		public node(int idx) {
			this.idx = idx;
		}
		public void setPrev(node prevNode) {
			this.prev = prevNode;
		}
		public void setNext(node nextNode) {
			this.next = nextNode;
		}
	}
	static class nodeList{
		node[] data;
		int size; int StartP = 0; int EndP = 0;
		int capa = 8;
		public nodeList() {
			data = new node[capa];
			size = 0;
		}
		void reallocate() {
			capa <<= 1;
			node[] temp = new node[capa];
			for(int i=0;i<size;i++) {
				temp[i] = data[i];
			}
			data = temp;
		}
		void add(node a) {
			if(capa == EndP) {
				reallocate();
			}
			if(EndP == 0) {
				a.prev = null;
				a.next = null;
				data[EndP] = a;
				EndP++;
			}else {
				a.prev = data[EndP-1];
				a.next = null;
				data[EndP-1].next = a;
				data[EndP] = a;
				EndP++;
			}
			size++;
		}
		//이부분이 맘에 안드는데;;;;; 링크드리스드로?
		void delete(int num) {
			node del = data[num];
			node delPrev = del.prev;
			node delNext = del.next;
			
			if(delPrev == null) {		// StartP == num
				del = null;
				StartP++;
			} else if(delNext == null) {// EndP == num
				
			} else {					//
				
			}
			
			size--;
		}
		node get(int num) {
			return data[num];
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
			list[hash(n)].add(n);
		}
		void delete(String s, int idx) {
			int hashValue = hash(new node(s));
			BreakPoint:
				for(int i=0;i<list[hashValue].size; i++) {
					if(s.length() == list[hashValue].get(i).s.length() && 
						idx == list[hashValue].get(i).idx) {
						for(int j=0;j<s.length();j++) {
							if(s.charAt(j) != list[hashValue].get(i).s.charAt(j)) {
								continue BreakPoint;
							}
						}
						list[hashValue].delete(i);
						i--;
					}
				}
		}
		void change(int idx, String s, node n) {
			int hashValue = hash(new node(s));
			BreakPoint:
				for(int i=0;i<list[hashValue].size; i++) {
					if(s.length() == list[hashValue].get(i).s.length() && 
						idx == list[hashValue].get(i).idx) {
						for(int j=0;j<s.length();j++) {
							if(s.charAt(j) != list[hashValue].get(i).s.charAt(j)) {
								continue BreakPoint;
							}
						}
						list[hashValue].delete(i);
						list[hash(n)].add(n);
						return;
					}
				}
		}
		nodeList getList(String s) {
			nodeList ret = new nodeList();
			int hashValue = hash(new node(s));
			
			BreakPoint:
				for(int i=0;i<list[hashValue].size; i++) {
					if(s.length() == list[hashValue].get(i).s.length()) {
						for(int j=0;j<s.length();j++) {
							if(s.charAt(j) != list[hashValue].get(i).s.charAt(j)) {
								continue BreakPoint;
							}
						}
						ret.add(list[hashValue].get(i));
					}
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
		node nodeName = new node(name, index);
		node nodeNumber = new node(number, index);
		node nodeBirth = new node(birthday, index);
		node nodeEmail = new node(email, index);
		node nodeMemo = new node(memo, index);
		
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
		nodeList ret = FTList[field].getList(str);
		for(int i=0;i<ret.size; i++) {
			int num = ret.get(i).idx;
			for(int j=0;j<5;j++) {
				FTList[j].delete(RT.table[num][j].s, RT.table[num][j].idx);
			}
		}
		return ret.size;
	}

	int Change(int field, String str, int changefield, String changestr)
	{
		nodeList ret = FTList[field].getList(str);
		for(int i=0;i<ret.size;i++) {
			int num = ret.get(i).idx;
			node n = new node(changestr, num);
			FTList[changefield].change(num, RT.table[num][changefield].s, n);
			RT.table[num][changefield] = n;
		}
		return ret.size;
	}

	Solution.Result Search(int field, String str, int returnfield)
	{
		nodeList ret = FTList[field].getList(str);
		Solution.Result result = new Solution.Result();
		result.count = ret.size;
		if(result.count == 1) {
			result.str = RT.table[ret.get(0).idx][returnfield].s;
		}else {
			result.str = "";
		}
		return result;
	}
}