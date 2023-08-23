package days10;

//객체 배열

class Studen{
	int bunho;
	String name;
	int []scores;
	static int count = 0;
	
	Studen(){
		scores=new int[3];
		bunho= ++count;
		name = "student"+count;
	}
}
public class Class29 {

	public static void main(String[] args) {

		int []a = new int[5]; //다섯칸짜리 정수 배열 생성 : 배열의 이름 a -> a가 배열의 참조값 저장
		String []s=new String[5]; //다섯칸짜리 String 배열 생성 : 배열의 이름 s -> s가 배열의 참조값 저장
		System.out.println("정수배열 첫번째 값 : "+a[0]); //0출력
		System.out.println("String 배열 첫번째 값 : "+s[0]); //null 출력
		
		Studen [] std = new Studen[5]; //객체 배열 생성
//		std[0].bunho=1; //에러
//		std[0].name="홍길동"; //에러

//		객체배열을 만들면 배열의 각 한칸 한칸들은 모두 참조변수가 됨
//		new Studen[5] ->다섯개짜리 참조 변수를 만든 것임
		
//		std[0]=new Studen();
//		std[1]=new Studen();
//		std[2]=new Studen();
//		std[3]=new Studen();
//		std[4]=new Studen();
		for(int i=0; i<std.length; i++)
			std[i]=new Studen();
		
		
//		결론 : 배열만 만들면 끝이 아니라 배열의 한칸 한칸에 뉴인스턴스의 주소를 채워줘야 배열의 요소개수만큼 객체 사용 가능
		for(int i=0; i<std.length; i++)
			System.out.println("번호 : "+std[i].bunho+" 이름 : "+std[i].name);
	}
}
