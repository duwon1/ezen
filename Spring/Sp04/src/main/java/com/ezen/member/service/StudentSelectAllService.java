package com.ezen.member.service;

import java.util.ArrayList;

import com.ezen.member.dao.StudentDao;
import com.ezen.member.dto.Student;

public class StudentSelectAllService {
	
	private StudentDao sdao;
	
	StudentSelectAllService( StudentDao studentdao ){
	    this.sdao = studentdao;
	}

	public ArrayList<Student> selectAllStudent() {
		//ArrayList<Student> list = sdao.selectAllStudent();
		//return null;
		return sdao.selectAllStudent();
	}

}
