package com.ezen.member.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.member.dto.Student;
import com.ezen.member.service.SelectOneService;
import com.ezen.member.service.StudentInsertService;
import com.ezen.member.service.StudentSelectAllService;
import com.ezen.member.service.StudentUpdateService;

public class MainClass {

	public static void main(String[] args) {

		// 기존방식의 레코드 추가
		// StudentDao sdao = new StudentDao();
		// Student std = new Student();
		// sdao.insertStudent(std);
		
		String[] sNums= {"H39asdkjashfks23","H39sdkjfhskfg123","H39lkdjsfksajfd525","H30qdfsfsf385fk",
				"H3fghdfhdfghfks23","H39dgfjgddfh","H3dgfhdfhfks23","H39afks23","H39asdkks23"};
		
		String[] sIds = {"hippo","raccoon","elephant","lion","tiger","pig","horse","bird","derar"};
		
		String[] sPws = {"13415","5463534","453453","145345315","13375","75545","967235","123335","453453"};
		
		String[] sNames = {"barbara", "chris", "doris", "elva",	"fiona", "holly", "jasmin", "lena", "melissa"};
		
		int[] sAges = {22,20,27,19,21,19,25,22,24};
		
		String[] sGenders = {"W","W","M","M","M","W","M","W","W"};
		
		String[] sMajors = {"korean Literature", "French Literature", "Philosophy","History","Law","Statistics",
				"Computer","Economics","Public Admin",
		};
		
		

		// 스프링 컨테이너를 이용한 방법
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

	

		//StudentDao sdao = ctx.getBean("studentdao", StudentDao.class);
		//sdao.insertStudent(std);
		
		StudentInsertService sis = ctx.getBean("insertService", StudentInsertService.class);
		//Student std = new Student("H39asdfaelu42o23", "hippo", "94875", "barabra", 22, "W", "Korean Literature");
		// 생성자에 전달인수 전달하여 객체 생성		
		//sis.insertStudent(std);
		
		
		
		//for(int i=0; i<sNums.length; i++) { Student std = new Student(sNums[i],
		// sIds[i],sPws[i], sNames [i], sAges [i],sGenders[i],sMajors [i]);
		// sis.insertStudent(std);
		 
		//}
		
		
		// 모든 학생 조회
		StudentSelectAllService sas = ctx.getBean("selectAllService", StudentSelectAllService.class);
		ArrayList<Student> list = sas.selectAllStudent();
		
		for(int i=0; i<list.size(); i++) {
			System.out.print("| sNum : " + list.get(i).getsNum() + "\t");
			System.out.print("| sId : " + list.get(i).getsId() + "\t");
			System.out.print("| sPw : " + list.get(i).getsPw() + "\t");
			System.out.print("| sName :" + list.get(i).getsName() + "\t");
		    System.out.print("| sAge : " + list.get(i).getsAge() + "\t");
			System.out.print("| sGender : " + list.get(i).getsGender() + "\t");
			System.out.print("| sMajor : " + list.get(i).getsMajor() + "\n");
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("조회할 학생의 아이디를 입력하세요\n");
		String ids = sc.nextLine();
		
		SelectOneService sos = ctx.getBean("selectOneService", SelectOneService.class);
		Student std = sos.selectOneStudent(ids);
		
		if( std==null) {
			System.out.println("조회한 아이디의 학생이 없습니다");
			return;
		}
   
		System.out.print("sNum:" + std.getsNum() + "\n");
		System.out.print("|sId:" + std.getsId() + "\n");
		System.out.print("|sPw:" + std.getsPw() + "\n");
		System.out.print("|sName:" + std.getsName() + "\n");
		System.out.print("|sAge:" + std.getsAge() + "\n");
		System.out.print("|sGender:" + std.getsGender() + "\n");
		System.out.print("|sMajor:" + std.getsMajor() + "\n\n");
			
    
	// 학생 정보 수정
    System.out.printf("수정할 학생의 아이디를 입력하세요 : ");
	ids = sc.nextLine();
	std = sos.selectOneStudent(ids);
	if( std==null) {
		System.out.println("조회한 아이디의 학생이 없습니다");
		return;
	}
	
	System.out.printf("기존비밀번호 : %s - 수정할 비밀번호를 입력 하세요 : ", std.getsPw() );
	String pw = sc.nextLine();
	if( !pw.equals("") ) std.setsPw(pw);
	
	System.out.printf("기존 성명 : %s - 수정할 성명를 입력 하세요 : ", std.getsName() );
	String name = sc.nextLine();
	if( !name.equals("") ) std.setsName(name); 
	
	System.out.printf("기존 나이 : %d - 수정할 나이를 입력 하세요 : ", std.getsAge() );
	String age = sc.nextLine();
	if( !age.equals("") ) std.setsAge( Integer.parseInt( age ) ); 
	
	System.out.printf("기존 성별 : %s - 수정할 성별를 입력 하세요 : ", std.getsGender() );
	String gender = sc.nextLine();
	if( !gender.equals("") ) std.setsGender(gender); 
	
	System.out.printf("기존 전공 : %s - 수정할 전공을 입력 하세요 : ", std.getsMajor() );
	String major = sc.nextLine();
	if( !major.equals("") ) std.setsMajor(major);
	
	StudentUpdateService us = ctx.getBean("updateService", StudentUpdateService.class);
	us.updateStudent(std);
	
	System.out.println("아래와 같이 수정되었습니다");
	Student ustd = sos.selectOneStudent(ids);
	
	System.out.print("sNum:" + ustd.getsNum() + "\n");
	System.out.print("|sId:" + ustd.getsId() + "\n");
	System.out.print("|sPw:" + ustd.getsPw() + "\n");
	System.out.print("|sName:" + ustd.getsName() + "\n");
	System.out.print("|sAge:" + ustd.getsAge() + "\n");
	System.out.print("|sGender:" + ustd.getsGender() + "\n");
	System.out.print("|sMajor:" + ustd.getsMajor() + "\n\n");
	
	
	
	
  }	
}