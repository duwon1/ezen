package days09;

//멤버메서드를 제작하는 주된 목적은 private으로 보호되는 멤버변수에 값을 저장하거나 얻어오거나...
//그 둘의 목적이 가장 큽니다.
//따라서 특정 멤버 메서드(값을 저장하거나 얻어오는 메서드)를 별도의 사유없이 필요한 만큼 만들고 시작하는 경우가 많음
//메서드의 이름은 getter setter와 멤버변수이름을 조합해서 만듦

class GetSetTest{
	private int intVar;
	private double doubleVar;
	private String stringVar;
	private boolean booleanVar;
	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public double getDoubleVar() {
		return doubleVar;
	}
	public void setDoubleVar(double doubleVar) {
		this.doubleVar = doubleVar;
	}
	public String getStringVar() {
		return stringVar;
	}
	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}
	public boolean isBooleanVar() {
		return booleanVar;
	}
	public void setBooleanVar(boolean booleanVar) {
		this.booleanVar = booleanVar;
	}
	
//	public void setIntVar(int intVar) {
//		this.intVar =intVar;
//		//매개변수와 멤버변수가 이름이 같은 경우 둘을 구분하기 위해 멤버변수에 this.를 붙여서 사용함
//	}
//	public int getIntVar() {
//		return intVar;
//	}
	
	//이클립스 메뉴 중에는 클래스의 private 멤버변수에 대한 getter, setter 메서드를 자동생성해주는 메뉴가 있다
	
//	 getter와 setter의 자동 생성
//	현위치에서 마우스 오른쪽 버튼 클릭
//	->Source 메뉴
//	->Generate Getters and Setters 선택
//	->selectAll 클릭
//	->Generate 클릭
	
	
	
}

public class Class08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
