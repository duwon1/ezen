package days11;

public class PlayingGame {

	public static void main(String[] args) {
		
//		Card c1 = new Card(3, 3);
//		Card c2 = new Card();
//		String s1=c1.toString();
//		String s2=c2.toString();
//		System.out.println(s1);
//		System.out.println(s2);

		Deck deck = new Deck();//52장의 카드가 deck에 생성됨
//		Card c1 = deck.pick(0);
//		Card c2 = deck.pick(1);
//		Card c3 = deck.pick(50);
//		Card c4 = deck.pick(51);
//		System.out.println(c1.toString());
//		System.out.println(c2.toString());
//		System.out.println(c3.toString());
//		System.out.println(c4.toString());
//		
		deck.shuffle();
//		System.out.println();
//		c1 = deck.pick(0);
//		c2 = deck.pick(1);
//		c3 = deck.pick(50);
//		c4 = deck.pick(51);
//		System.out.println(c1.toString());
//		System.out.println(c2.toString());
//		System.out.println(c3.toString());
//		System.out.println(c4.toString());
		
		Card[]player1 =new Card[5];
		Card[]player2 =new Card[5];
		Card[]player3 =new Card[5];
		Card[]player4 =new Card[5];
		
//		1명 당 5장씩 분배하고 한명 당 1줄에 보유카드를 한번에 출력해서 4줄 출력\
		int cardIndex=0;
		for(int i=0;i<5;i++) {
				player1[i]=deck.pick(cardIndex++);
				player2[i]=deck.pick(cardIndex++);
				player3[i]=deck.pick(cardIndex++);
				player4[i]=deck.pick(cardIndex++);
		}
		for(int i=0; i<5; i++) {
			System.out.printf("%s ", player1[i]);
		} //toString: 메소드값을 출력할때 이상한 숫자인 해시태그대신 String으로 출력해줌
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.printf("%s ", player2[i]);
		}
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.printf("%s ", player3[i]);
		}
		System.out.println();
		for(int i=0; i<5; i++) {
			System.out.printf("%s ", player4[i]);
		}
		System.out.println();
	
	//---------------------------------------------------------------
		Card c1= new Card(Card.diamond,13);
		System.out.println(c1.toString());
		Card c2 = new Card();
		System.out.println(c2.toString());
		
//		toString() 메서드를 정의하고 포함한 클래스
//		그 클래스 형태대로 만든 객체는 System.out.printf()으로 참조변수를 출력했을 때
//		"패키지이름.클래스이름@해시코드"가 출력되는 것이 아니라
//		toString() 메서드가 리턴해주는 String 값이 출력됨
		System.out.println(c1);	//c1뒤에 .toString()이 생략된 형태라고 보면 됨
		System.out.println(c2);
		
//		이것은 참조변수 단독으로 사용되기보단 다른연산에 참조변수가 참여하고 있을 때 적용되는 규칙
		String result = "카드 1 : "+c1;
		System.out.println(result);
		result="카드 2 : "+c2;
		System.out.println(result);
		
		
	}

}
