package days01;

public class Print01 {

	public static void main(String[] args) {
		System.out.printf("대통령은 조약을 \"체결-비준\"하고,\n");  
		System.out.printf("외교사절을 \"신임-접수\" 또는 \"파견\"하며,\n");
		System.out.printf("\'선전포고\'와 \'강화\'를 한다.\n\n");
		System.out.printf("대통령의 임기가 만료되는 때에는 \n");
		System.out.printf("임기만료 70%% 내지 40%% 전에 후임자를 선거한다\n\n"); 
		
		System.out.printf("\\n : new line\n");        //    \n : new line
		System.out.printf("\\t : tab\n");               //     \t : tab
		System.out.printf("\\b : 백스페이스\n");       //    \b : 백스페이스
		System.out.printf("\\\' : \' 출력\n");           //    \\\' : \' 출력 
		System.out.printf("\\\" : \"출력\n");           //     \\\" : \"출력
		System.out.printf("%%%% : %%출력\n"); //     %% : %출력
		System.out.printf("\\\\ : 역슬래시 출력\n");    //     \\ : 백슬래시 출력

		System.out.printf("abcdefg\b\b\babc");
	}

}
