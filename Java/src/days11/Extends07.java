package days11;

class SuperE{
	SuperE(){//3
		this(5);
		System.out.println("SuperE()");
	}
	SuperE(int i){//2
		this(10.12);
		System.out.println("SuperE(int)");
	}
	SuperE(double d){//1
		System.out.println("SuperE(double)");
	}
	SuperE(String s){//4
		this();
		System.out.println("SuperE(String)");
	}
}

class SubE extends SuperE{
	SubE(){//8
		this(""); //String 형제생성자 호출
		System.out.println("SubE()");
	}
	SubE(int i){//5
		super(""); //String 부모생성자 호출
		System.out.println("SubE(int)");
	}
	SubE(double d){//6
		this(3);
		System.out.println("SubE(double)");
	}
	SubE(String s){//7
		this(123.12);
		System.out.println("SubE(String)");
	}
}

public class Extends07 {

	public static void main(String[] args) {
		SubE s= new SubE();
	}
}
