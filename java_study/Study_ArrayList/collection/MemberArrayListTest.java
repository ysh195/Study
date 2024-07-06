package collection;

import arraylist.MemberArrayList;

public class MemberArrayListTest {

	public static void main(String[] args) {
		
		MemberArrayList memberArrayList = new MemberArrayList();
		
		Member member1 = new Member(1001,"이지원");
		Member member2 = new Member(1002,"손민국");
		Member member3 = new Member(1003,"박서훤");
		Member member4 = new Member(1004,"홍길동");
		
		
		memberArrayList.addMember(member1);
		memberArrayList.addMember(member2);
		memberArrayList.addMember(member3);
		memberArrayList.addMember(member4);
		
		memberArrayList.showAllMember();
		
		memberArrayList.removeMember(member4.getMemberId());
		memberArrayList.showAllMember();		

	}

}
