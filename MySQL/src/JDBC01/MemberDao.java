package JDBC01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;





public class MemberDao {
    
	private MemberDao() {}
	private static  MemberDao itc = new MemberDao();
	static  MemberDao getInstance() { return itc;}
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberDto> selectMember(){
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		con = DBManager.getConnection();
		String sql = "select "
				+ " memberlist.*, "
				+ " date_format( birth, '%Y%m%d') as bd,"
				+ " date_format(joindate,'%Y%m%d') as jd "
				+ " from memberlist order by membernum desc";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while( rs.next()) {
			 MemberDto mdto = new MemberDto();
			 mdto.setMembernum(rs.getInt("membernum"));
			 mdto.setName(rs.getString("name"));
			 mdto.setPhone(rs.getString("phone"));
			 mdto.setBirthday(rs.getString("bd"));
			 mdto.setBpoint(rs.getInt("bpoint"));
			 mdto.setJoindate(rs.getString("jd"));		
			 mdto.setAge(rs.getInt("age"));
			 mdto.setGender(rs.getString("gender"));
			 list.add(mdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		System.out.println(list.size());
		DBManager.close( con, pstmt,rs);
		return list; 
	}

	public int insertMember(MemberDto mdto) {
		int result = 0;
		
		con = DBManager.getConnection();
		String sql = "insert into memberlist( name, phone, birth, gender, age) "
				+ " values( ?, ?, str_to_date( concat('',?,'' ), '%Y-%m-%d'),?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  mdto.getName() );
			pstmt.setString(2,  mdto.getPhone() );
			pstmt.setString(3,  mdto.getBirthday() );
			pstmt.setString(4,  mdto.getGender() );
			pstmt.setInt(5,  mdto.getAge() );
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);  }		
		  return result;
	
	}

	public MemberDto getMember(int membernum) {
		MemberDto mdto = null;
		con = DBManager.getConnection();
		String  sql = "select date_format( birth, '%Y-%m-%d') as bd,"
			    + " date_format( joindate,'%Y-%m-%d') as jd,memberlist.*"
				+ " from memberlist where membernum = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, membernum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mdto = new MemberDto();
				mdto.setMembernum( rs.getInt("membernum") );
				mdto.setName( rs.getString("name") );
				mdto.setPhone( rs.getString("phone") );
				mdto.setBirthday( rs.getString("bd") );
				mdto.setBpoint( rs.getInt("bpoint") );
				mdto.setJoindate( rs.getString("jd") );
				mdto.setGender( rs.getString("gender") );
				mdto.setAge( rs.getInt("age") );								
				
			}			
		} catch (SQLException e) { e.printStackTrace();
		}finally { DBManager.close(con, pstmt, rs);  }
		
		return mdto;
	}

	public int updateMember(MemberDto mdto) {
		int result = 0;
		con = DBManager.getConnection();
		String sql = "update memberlist set name=?, phone=?,"
				+ " birth=str_to_date( concat('', ? ,''), '%Y-%m-%d'), "
				+ " joindate=str_to_date( concat('', ? ,''), '%Y-%m-%d'), "
				+ " gender=? , age=? , bpoint=? where membernum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  mdto.getName() );
			pstmt.setString(2,  mdto.getPhone() );
			pstmt.setString(3,  mdto.getBirthday() );
			pstmt.setString(4,  mdto.getJoindate() );
			pstmt.setString(5, mdto.getGender() );
			pstmt.setInt(6, mdto.getAge() );
			pstmt.setInt(7, mdto.getBpoint() );
			pstmt.setInt(8, mdto.getMembernum() );		
			result=pstmt.executeUpdate(); 
		} catch (SQLException e) { e.printStackTrace();
		} finally { DBManager.close(con, pstmt, rs);  }		
		return result;
		 
		
	}


}
