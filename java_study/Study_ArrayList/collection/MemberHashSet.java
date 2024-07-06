package collection;

import java.util.Iterator; // 컬렉션 내의 요소에 접근하기 위한 사서 역할. 근데 한 번에 하나밖에 못 가져오고, 처음부터 끝까지 다 가져올 뿐임
import java.util.HashSet;

import collection.Member;

public class MemberHashSet {
	private HashSet<Member> hashSet;
	
	public MemberHashSet() {
		hashSet = new HashSet<Member>();
	}
	
	public void addMember(Member member) {
		hashSet.add(member);
	}
	
	public boolean removeMember(int memberId) {
		Iterator<Member> ir = hashSet.iterator();
		
		while(ir.hasNext()) {
			Member member = ir.next();
			int tempId = member.getMemberId();
			if(tempId == memberId) {
				hashSet.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : hashSet) { // 허쉬셋이 멤버의 arrayList인가?
			System.out.println(member);			
		}
		System.out.println("");
	}

}
