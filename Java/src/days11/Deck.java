package days11;

public class Deck {
	
	private Card[] cards=new Card[52];
//	cards[0]= new Card(Card.spade, 1);
//	cards[51]=new Card(Card.clover,13);


	Deck() { //52개의 카드 생성자
		int cardIndex=0;
		for(int kind=4; kind>=1;kind--) {
			for(int num=1;num<=13; num++) {
				cards[cardIndex]=new Card(kind,num);
				cardIndex++;
			}
		}
	}
	public Card pick(int i) { //카드 뽑는 메서드
		return cards[i]; // 전달된 i 값에 의해 i번째 카드가 리턴
	}
	public void shuffle() { //카드섞는 메서드
		for(int i =0; i<cards.length; i++) {
			//반복이 실행되는 동안 i번째 카드와 random번째 카드의 자리를 서로 맞바꿈
			int r=(int)(Math.random()*52);
			Card temp = cards[i];
			cards[i]=cards[r];
			cards[r]=temp;
		}
		
	}
}
