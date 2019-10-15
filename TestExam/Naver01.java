package com.ssafy.git.TestExam;

public class Naver01 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		String[] str = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz", "@.com" };
		int ans = solution(str);
		System.out.println(ans);
	}

	static int solution(String[] str) {
		// TODO Auto-generated method stub
		int ret = 0;
		for(String s : str) {
			String[] splitStr = s.split("@");
			
			if(splitStr.length != 2) {
				continue;
			}
			
			String name = splitStr[0]; int nameLen = name.length();
			boolean nameValid = true;
			for(int i=0;i<nameLen;i++) {
				char a = name.charAt(i);
				if(!((a >= 'a' && a<='z') || a == '.')) {
					nameValid = false;
					break;
				}
			}
			if(!nameValid || !(name.length() >= 1)) {
				continue;
			}
			
			String[] domain = splitStr[1].split("\\.");
			if(domain.length != 2) {
				continue;
			}
			int domainLen = domain[0].length();
			boolean domainValid = true;
			for(int i=0;i<domainLen;i++) {
				char a = domain[0].charAt(i);
				if(!(a >= 'a' && a<='z')) {
					domainValid = false;
					break;
				}
			}
			if(!domainValid || !(domain[0].length() >= 1)) {
				continue;
			}
			if(domain[1].equals("com") || domain[1].equals("net") || domain[1].equals("org")) {
				ret++;
			}
		}
		return ret;
	}
	
	
}
