package days11;

//toString 메서드의 사용
class Point{
	private int x;
	private int y;
	Point(int x, int y){this.x=x; this.y=y;}
	//toString 메서드를 "x:30, y;20"라는 String 데이터가 리턴되도록 오버라이딩하세요

	public String toString() {
		String result = "x:"+this.x+", y:"+this.y;
		return result;
}
}
public class Extends09_Object02 {

	public static void main(String[] args) {

		Point p = new Point(30,20);
		System.out.println("오버라이딩 안된 toString() =>"+ p.toString());
		System.out.println("오버라이딩 된 toString() =>"+ p.toString());
	}
}
