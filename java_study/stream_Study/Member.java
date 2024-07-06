package test;

public class Member {
	private String ID;
	private String PW;
	private String nickName;
	
	public String getID() {
		return ID;
	}
	
	public Member(String iD, String pW, String nickName) {
		this.ID = iD;
		this.PW = pW;
		this.nickName = nickName;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
