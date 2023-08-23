package days13;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

// Hashtable, HashMap 클래스
//데이터베이스 내부의 키 값을 검색하기 위해서 만들어진 알고리즘을 기반으로 작성된 클래스
//-검색을 위해 사용되는 클래스
//-Key, Value를 저장할 수 있는 클래스
//-Key는 중복 허용 안함
//-Value는 중복 허용

//저장 예
//HashMap<Integer, String> hm = new HashMap();
//hm.put(1, "One");
//hm.put(2, "Two");
//hm.put(3, "Three");

//자료형이 다른 객체들은 효과적으로 저장하고 전송하기 위해 ArrayList 다음으로 많이 사용되는 자료구조임

public class Collection04 {

	public static void main(String[] args) {

		//Key 값은 String , Value값은 Integer형의 자료를 Hashtable에 저장할 객체를 생성
		Hashtable<String, Integer> ht = new Hashtable();
		
		//같은 제네릭형의 HashMap 생성
		HashMap<Integer, String> hm = new HashMap<>();
		
		//실제로 여러 자료형이 함께 저장될 HashMap의 형태는 아래와 같음
//		HashMap<String, Object> hm2 = new HashMap()<>;
		
		//Hashtable, HashMap 클래스는 put 메소드를 사용해 데이터 추가
		ht.put("One", 1);
		ht.put("Two", 2);
		ht.put("Three", 3);
		hm.put(1, "One");
		hm.put(2, "Two");
		hm.put(3, "Three");
		
		//Hashtable, HashMap 클래스는 get메소드에 Key값을 전달해 Value를 리턴받음
		System.out.printf("Hashtable\"Three\"=>%d\n", ht.get("Three"));
		System.out.printf("HashMap 3 =>\"%s\"\n", hm.get(3));
		
		//반복문을 이용해서 Hashtable, HashMap 에 Value들을 출력하려면, 별도의 객체 필요
		//Enumeration 객체 : Enumeration은 열거형 자료형식(인터페이스)임
		Enumeration<String>e1= ht.keys();//키값들은 리스트형식으로 얻어서 저장
		
		while(e1.hasMoreElements()) {
			String k = e1.nextElement();  //ht.keys() 에서 얻은 key값들 중 하나를 추출
			int v = ht.get(k);
			System.out.printf("key(%s)=Value(%d) \n", k, v);
		}//Hashtable 과 HashMap은 저장된 자료들이 key값으로 구분될 뿐 순서가 없어서 무순위로 출력됨
		
		System.out.println();
		//for 문을 활용해 Key값을 순회하는 방법
		for(Integer k : hm.keySet()) {//hm.keySet() :키값들만 모아서 리스트로 생성
			String v = hm.get(k);
			System.out.printf("key(%d)=Value(%s)\n",k,v);
		}
	
		//확장 사용 예
		HashMap<Integer,Object>hm2 = new HashMap<Integer, Object>();
		//key:1 value:"abcd"
		//key:2 value:1234
		//key:3 value:23.56
		//key:4 value:{"abcd", "efg", "hij"}
		
		HashMap<Integer, ArrayList<String>> hm3=new HashMap<>();
		//key:1 value:{"abcd", "efg", "hij"}
		//key:2 value:{"dddd", "ffff", "eeeee", "dkdkdZ"}
	}

}
