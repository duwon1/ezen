package com.ezen.member.service;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentInsertService {

	
	private StudentDao sdao;
	
	StudentInsertService(StudentDao studentdao){
		this.sdao = studentdao;
		
	}
	
	public void insertStudent(Student std) {
		// StudentDao 의 insertStudent 메서드를 호출함.
		//GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//StudentDao sdao = ctx.getBean("studentdao", StudentDao.class);
		
		sdao.insertStudent(std);

	}
}
