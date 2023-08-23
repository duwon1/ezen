package com.ezen.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ezen.member.dto.DataBaseConnectionInfo;
import com.ezen.member.dto.Student;


public class StudentDao {

	// 스프링 컨테이너에 넣어서 사용할 예정이므로, 싱글턴 코딩은 하지 않음

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String driver;
	String url;
	String id;
	String pw;

	StudentDao(DataBaseConnectionInfo dbconinfo) { // 생성자에 전달인수가 객체인 형태
		this.driver = dbconinfo.getDriver();
		this.url = dbconinfo.getUrl();
		this.id = dbconinfo.getId();
		this.pw = dbconinfo.getPw();
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close() {
		try {
			if (con != null)
				con.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

public void insertStudent(Student std) {
    
    String sql = "insert into student(snum, sid, spw, sname, sage, "
                    + "sgender, smajor) values(?,?,?,?,?,?,?)";
    con = getConnection();
    try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,  std.getsNum());
            pstmt.setString(2,  std.getsId());
            pstmt.setString(3,  std.getsPw());
            pstmt.setString(4,  std.getsName());
            pstmt.setInt(5,  std.getsAge());
            pstmt.setString(6,  std.getsGender());
            pstmt.setString(7,  std.getsMajor());
            pstmt.executeUpdate();                
    } catch (SQLException e) {e.printStackTrace();
    } finally {      close();  }                
}

public ArrayList<Student> selectAllStudent() {
	ArrayList<Student> list = new  ArrayList<Student>();
	
	String sql = "select * from student";
	con = getConnection();
	try {
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while( rs.next() ) {
			Student std = new Student(
					rs.getString("sNum"),
					rs.getString("sId"),
					rs.getString("sPw"), 
					rs.getString("sName"), 
					rs.getInt("sAge"),	
					rs.getString("sGender"), 
					rs.getString("sMajor") 
			);  // 생성자 함수를 이용하여 객체 생성
			list.add(std);
		}
	} catch (SQLException e) {e.printStackTrace();
	} finally { close();  }
	
	return  list;
}

public Student selectOneStudent(String ids) {
	Student std = null;
	String sql = "select * from student where sId=?";
	con = getConnection();
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ids);
		rs = pstmt.executeQuery();
		if( rs.next() ) {
			std = new Student( 
					rs.getString("sNum"), 
					rs.getString("sId"),
					rs.getString("sPw"), 
					rs.getString("sName"),
					rs.getInt("sAge"), 
					rs.getString("sGender"), 
					rs.getString("sMajor")	);
		}
	} catch (SQLException e) {e.printStackTrace();
	} finally { close(); }	
	return std;
}




public void UpdateStudent(Student std) {
	
	String sql = "update student set sPw=?, sName=?, " + 
			" sAge=?, sGender=?, sMajor=? where sId=?";
	con = getConnection();
	try {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,  std.getsPw());
		pstmt.setString(2,  std.getsName());
		pstmt.setInt(3,  std.getsAge());
		pstmt.setString(4,  std.getsGender());   
		pstmt.setString(5,  std.getsMajor());
		pstmt.setString(6,  std.getsId());    
		
		pstmt.executeUpdate();
		
	} catch (SQLException e) {e.printStackTrace();
	} finally { close(); }
	
	
}









	




}
