package days13;

import java.util.ArrayList;
import java.util.Vector;

//컬렉션 클래스(컬렉션 프레임워크)
//자료구조를 구현하고 있는 클래스
//자료구조 : 각각의 데이터들을 효율적으로 저장하고 운용하기 위한 방법론

//1.배열
//-다수개의 요소를 저장, 번호(첨자)에 의해 손쉬은 접근 방법을 제공
//-크기가 고정, 데이터의 중간삽입고 중간삭제에 비효율적

//2.리스트(List)
//-크기의 제약없이 데이터를 저장할 수 있음, 데이터의 삽입과 삭제에 최적화
//-검색에 취약 -(참조값(주소)를 저장하기 때문에 )-이를 개선하기 위한 더블 링크드 리스트를 사용하기도 함
//-데이터 저장시 불필요한 메모리 사용
//자바의 모든 자료구조 클래스(컬렉션 클래스)들은 java.util 패키지를 통해 제공받을 수 있음
//위와 같은 동적 배열을 구현하고 있는 클래스들 -Vector, ArrayList(가장 많이 사용)
//링크드 리스트를 구현하고 있는 클래스-LinkedList

//3.Set 타입의 저장방법을 구현하고 있는 클래스들
//Set 타입 : 데이터를 저장할 때, 중복을 허용하지 않는 방법:
//	검색을 위해서 사용, 중복된 값을 제거하기 위해서 사용
//	-HashSet(사용빈도 : 중), TreeSet
	
//4. Map타입의 저장방법을 구현하고 있는 클래스들
//Map 타입 : 데이터를 Key와 Value의 형태로 저장하는 방법
//(검색을 위해서 사용, Key의 값은 중복을 허용하지 않음, Value값은 중복을 허용)
//-Hashtable, HashMap(가장 많이 사용)(사용빈도:상)

//5. Vector, ArrayList클래스
//-두개의 클래스는 동일한 기능을 제공
//-쓰레드 동기화의 지원여부 크기의 제약없이 데이터를 저장(동적으로 크기 확장)
//-배열과 같이 인덱스를 기반으로 데이터를 접근
//-데이터의 중복을 허용
//-데이터의 입력 순서를 유지

public class Collection01 {

	public static void main(String[] args) {
		
		Vector v = new Vector();
		//동적 배열의 객체 생성 초기값으로 크기를 지정할 수 있지만 통상 크기 지정없이 사용
		ArrayList a = new ArrayList();
		
		v.add(10);
		v.add(20);
		v.add(30);
		
		a.add(10);
		a.add(20);
		a.add(30);
		
		// 이 둘은 모두 10과 20과 30이 저장된 객체의 참조값이 저장됨
		//10, 20, 30이 직접 저장되는 건 아님
		
		//add 메서드의 매개변수가 무슨 형? Object
		//그래서 어떤 자료형의 객체이들 저장이 가능함
		// 10,20,30은 객체가 아니지만 저장될 때 Integer 형으로 자동 변환됨
		
		int b =(Integer) a.get(0);
		
		//Vector, ArrayList에 담겨있는 자료들의 개수를 리턴하는 메서드 : size()
		for(int i =0; i<v.size();i++) {
			b= (Integer)v.get(i);
			System.out.printf("v[%d]=%d\t\t",i,b);
		}
		//Vector, ArrayList 클래스의 get메서드 : 특정 인덱스에 저장되어 있는 데이터를 반환
		System.out.println();
		
		System.out.println();
		for(int i =0; i<a.size();i++)
			System.out.printf("a[%d]=%d\t\t", i, a.get(i));//최초상태 출력
		
		//인덱스 매개변수를 추가하여 데이터 삽입 -수정가능
		a.set(2, 100); //set는 기존값을 지우고 대입
		System.out.println();
		for(int i =0; i<a.size();i++)
			//v.get(i)를 %d에 적용할 때는 강제캐스팅 필요없음
			System.out.printf("a[%d]=%d\t\t", i, a.get(i));//100을 set하고 출력
		
		a.add(2,300);//add는 기존값들을 뒤로 밀고 중간에 삽입
		System.out.println();
		for(int i =0; i<a.size();i++)
			System.out.printf("a[%d]=%d\t\t", i, a.get(i));//300을 add하고 출력
		
		
		
	}

}
