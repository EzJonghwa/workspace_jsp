package model;


public class UserVO{
	
	private String userId;  // camel 표기법 _ <-- 뒤 단어 첫글자 대문자로
	private String userPw;
	private String userNm;
	private String userYn;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserYn() {
		return userYn;
	}
	public void setUserYn(String userYn) {
		this.userYn = userYn;
	}
	
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", userYn=" + userYn + "]";
	}
	
	

}
