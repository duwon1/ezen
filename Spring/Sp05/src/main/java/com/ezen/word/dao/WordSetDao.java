package com.ezen.word.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dto.WordSet;
import com.ezen.word.util.DataBaseManager;

public class WordSetDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Autowired
	DataBaseManager dbm;

	/*
	 * Public WordSetDao( DataBaseManager dbm) { this.dbm = dbm; }
	 */

	public void insertWord(WordSet wordSet) {

		String sql = "insert into wordset values(?, ?)";
		con = dbm.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, wordSet.getWordKey());
			pstmt.setNString(2, wordSet.getWordValue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(con, pstmt, rs);
		}
	}

	public ArrayList<WordSet> wordSelectAll() {
		ArrayList<WordSet> list = new ArrayList<WordSet>();
		String sql = "select * from wordset";
		con = dbm.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				WordSet ws = new WordSet(rs.getString("wordkey"), rs.getString("wordvalue"));
				list.add(ws);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbm.close(con, pstmt, rs);
		}
		return list;
	}

	public WordSet searchWord(String input) {
	    WordSet ws = null;
	    String sql = "select * from wordset where wordkey=?";
	    con = dbm.getConnection();
	    try {
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, input);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            ws = new WordSet(
	                    rs.getString("wordkey"),
	                    rs.getString("wordvalue")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbm.close(con, pstmt, rs);
	    }

	    return ws;
	}

}
