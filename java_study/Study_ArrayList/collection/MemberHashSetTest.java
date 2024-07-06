package collection;

import collection.Member; // 생각해보니 멤버 데이터가 들어간 저장소를 이렇게 빼면 굳이 상속이나 인터페이스로 받아올 필요도 없고,
// 생성자가 만들기 전에는 Member에 접근하기 어렵다는 문제를 해결할 수 있겠네? 그리고 어느 클래스에서나 부담없이 가져다 쓸 수 있겠네?

public class MemberHashSetTest {

	public static void main(String[] args) {
		MemberHashSet memberHashSet = new MemberHashSet(); // 참고로 자기 생성자 아님. 멤버 관리 메서드가 담긴 클래스의 생성자
		
		Member member1 = new Member(1001,"이지원");
		Member member2 = new Member(1002,"손민국");
		Member member3 = new Member(1003,"박서현");
		
		memberHashSet.addMember(member1);
		memberHashSet.addMember(member2);
		memberHashSet.addMember(member3);
		memberHashSet.showAllMember();
		
		Member member4 = new Member(1004,"홍길동"); 
		memberHashSet.addMember(member4);
		memberHashSet.showAllMember(); // 순서 자동 정렬이 안 됨.
	}

}
