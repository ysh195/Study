package arraylist;
// list는 저장하는 객체의 해쉬코드의 일치 여부로 중복값인지 파악함. 따라서 멤버 클래스 내부에서 해쉬코드를 생성하는 방식을 수정하면 중복 체크의 방법을 간접적으로 조절할 수 있음
// 근데 내부의 eqauls 메서드를 수정하는 걸로는 안 됨. 아무래도 객체의 equals를 사용해서 비교하는 게 아니라, arrayList 내부 절차를 통해 확인하는 듯
import java.util.*;
import collection.Member; // 내가 만든 컬렉션 패키지에서 가져올 수도 있네

public class MemberArrayList {
	
	private ArrayList<Member> arrayList; // 이 클래스는 arraylist 클래스임을 선언
	
	public MemberArrayList() {
		arrayList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberId) {
		for(int i=0; i<arrayList.size(); i++) {
			Member member = arrayList.get(i); // get 메서드로 회원 리스트를 가져옴
			int tempId = member.getMemberId(); // 가져온 회원의 멤버아이디를 임시 변수에 저장
			if(tempId == memberId) { // 저장된 아이디와 입력된 아이디가 같으면
				arrayList.remove(i); // 해당 회원 정보 저장
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false; // 근데 arrayList라고 하는 일이 크게 달라지진 않네. 원래 다 하던 거 아닌가
		
	}
	
	public boolean modified_removeMember(int memberId) {
		
		Iterator<Member> ir = arrayList.iterator(); // iterator 반환. Iterator 클래스가 따로 있어서 그걸 사용
		
		while(ir.hasNext()) { // 다음 순서의 요소가 존재하는가?
			Member member = ir.next(); // 다음 순서의 요소를 가져와서 member에 저장
			int tempId = member.getMemberId(); // memberId를 tempId에 저장
			if(tempId == memberId) { // 이건 왜 하는 거지? 방금 저장했으니 당연히 일치하지 않나?
				arrayList.remove(memberId); // 해당 Id를 가진 요소 삭제
				return true;
			}
		}
		
		System.out.println(memberId + "가 존재하지 않습니다."); // 다음 순서의 요소 없음
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList) {
			System.out.println(member);
		}
		System.out.println("");
	}
}
