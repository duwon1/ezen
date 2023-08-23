package com.ezen.member.service;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class SelectOneService {

	private StudentDao sdao;
	
	SelectOneService(StudentDao studentdao) {
	      this.sdao = studentdao;
	   }
	

	public Student selectOneStudent(String ids) {		
		return sdao.selectOneStudent( ids);
	}
	
	
	
	
	
}
