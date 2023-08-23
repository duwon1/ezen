package JDBC01;

public class MemberDto {

    private int membernum;
	private String name;
	private String phone;
	private String birthday;
    private int bpoint;
    private int age;
	private String gender;
	private String joindate;
	
	public int getMembernum() {
		return membernum;
	}
	
	
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public void setMembernum(int membernum) {
		this.membernum = membernum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getBpoint() {
		return bpoint;
	}
	public void setBpoint(int bpoint) {
		this.bpoint = bpoint;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoindate() {		
		return joindate;
	}
	
   
    
}
