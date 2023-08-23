package days09;


	class std{ // 같은 패키지 안에서는 클래스이름이 중복될수 x
		   private int bun;
		   private String name;
		   private int kor;
		   private int eng;
		   private int mat;
		   private int tot;
		   private double ave;
		   
		   public void input(int a ,String n, int b, int c, int d) {
		      bun = a;
		      name = n;
		      kor = b;
		      eng = c;
		      mat = d;
		      tot =b+c+d;
		      ave = tot/3.0;
		   }
		   
		   

		   public void prnScore() {
		      System.out.println(bun+"          "+name+"     "+kor+"         "+eng+"        "+mat+"       "+tot+"          "+ave);
		      
		   }
		}

		public class Class05 {

		   public static void main(String[] args) {

		      std s1=new std();
		      std s2=new std();
		      
		      s1.input(1,"홍길동", 88,77,99);
		      s2.input(2,"홍길서", 89,98,78);
		      
		      prnTitle();
		      
		      s1.prnScore();
		      s2.prnScore();
		      
		      System.out.println("----------------------------------------------------------------------------");
		      
		      

		   }

		   private static void prnTitle() 
		   {
		      System.out.println("                                 ###시간표###");
		      System.out.println("----------------------------------------------------------------------------");
		      System.out.println("번호      이름       국어      영어      수학      총점         평균");
		      System.out.println("----------------------------------------------------------------------------");

		      
		   }

		   

	}

