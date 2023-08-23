package days11;

public class Card {
//이 클래스 한장의 카드가 표현 또는 저장의 의미로 제작됨
	
	final static int spade =4;
	final static int diamond = 3;
	final static int heart = 2;
	final static int clover = 1;
	
	private int kind;  //spade:4  diamond:3  heart:2  clover:1 
	private int number;  //A 2 3 4 5 6 7 8 9 10 J Q K-> 0~13로 저장
	
	Card(){
		this(spade, 1);
	}
	Card( int kind, int number){
		this.kind=kind;
		this.number=number;
	}
	
	public String toString() {
		String[] kinds= {"", "Clover", "Heart", "Diamond","Spade"};
		String[]numbers= {"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String result = "["+kinds[this.kind]+":"+numbers[this.number]+"]";
		return result;
	}
}
