package days14;

interface Repairable{}

abstract class Unit{
	private int hp; //현재 생명력(체력)
	private int max_hp; //최대 생명력
	public int getHp() {		return hp;	}
	public void setHp(int hp) {		this.hp = hp;	}
	public int getMax_hp() {		return max_hp;	}
	public void setMax_hp(int max_hp) {		this.max_hp = max_hp;	}
	Unit(int p){
		max_hp = p;//캐릭터별 전달된 최대 체력 초기화
		hp = (int)(p*0.5); //현재 체력은 최대 90%로 초기화
	}
	//추상 클래스는 하나 이상의 추상 메서드를 포함함
	public abstract void move(int x, int y);
//	public void move(int x, int y) {
//		System.out.println("x:"+x+"y:"+y+"로 이동합니다.");
//	}
}

class GroundUnit extends Unit{
	GroundUnit(int p){	super(p);}
	public void move(int x, int y) {	System.out.println("x:"+x+" y:"+y+"로 이동합니다.");}
}

class AirUnit extends Unit{
	AirUnit(int p){super(p);}
	public void move(int x, int y) {System.out.println("x:"+x+" y:"+y+"로 날아갑니다.");	}
}

class Tank extends GroundUnit implements Repairable{
	Tank(){super(150);}
	public String toString() {
		return "Tank";
	}
}

class BattleCruiser extends AirUnit implements Repairable{
	BattleCruiser(){
		super(350);
	}
	public String toString() {
		return "Battlecruiser";
	}
}

class Marine extends GroundUnit{
	Marine(){	super(40);	}
	public String toString() {return "Marine";}
}

class SCV extends GroundUnit implements Repairable{
	SCV(){super(40);}
	public String toString() {return "SCV";}
	public void repair(Repairable r) {
		//this<-s1   r<-t, b, s2
		//this가 r을 수리합니다
		
		//전달된 객체의 hp, max_hp 등에 메소드들을 통해 접근하려면 Unit참조변수로 변환이 필요함
		//실제 인스턴스는 t, b, s2이므로 그들의 부모인 Unit 참조변수로 변환은 가능함
		//그래도 안전을 위한다면
		if(r instanceof Unit) {
			Unit u = (Unit)r;
			if(u.getHp() !=u.getMax_hp()) {
				while(u.getHp()!=u.getMax_hp()) {
					u.setHp(u.getHp()+5);
					System.out.println(u+" 체력 5를 repair했습니다. 현재 체력 : "+u.getHp());
				}
			}else {
				System.out.println(u+"의 hp는 만땅입니다");
				return;
			}
			System.out.println(u+"'s repair is done");
		}
	}
}
public class Interface04 {

	public static void main(String[] args) {

		Tank t = new Tank();
		BattleCruiser b = new BattleCruiser();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();
		
		System.out.print(t+" : ");
		t.move(10, 40);
		System.out.print(b+" : ");
		b.move(10, 40);
		System.out.print(m+" : ");
		m.move(10, 40);
		System.out.print(s1+" : ");
		s1.move(10, 40);
		
		s1.repair(t);
		s1.repair(b);
		s1.repair(s2);
//		s1.repair(m); //Marine didn't implemented Repairable 게임 규칙 상 불가
	}
}
