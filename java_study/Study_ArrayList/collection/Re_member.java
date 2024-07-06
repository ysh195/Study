package collection;

public class Re_member{

	private int memberId;
	private String memberName;
	
	public Re_member(int memberId, String memberName) {
		this.memberId=memberId;
		this.memberName=memberName; 
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberId + "입니다.";
	}
	
	public int hashCode() {
		return memberId;
	}
	
	public boolean equals(Object obj) {
		Member member = (Member)obj;
		
		if(this.memberId == member.getMemberId()) {
			return true;
		}
		else {
			return false;
		}
	}

}
