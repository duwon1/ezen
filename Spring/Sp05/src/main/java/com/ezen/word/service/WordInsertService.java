package com.ezen.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordSetDao;
import com.ezen.word.dto.WordSet;

public class WordInsertService {
	
	@Autowired
	private WordSetDao worddao;
	
	/*
	 * WordInsertService( WordSetDao wordsetdao){ this.worddao = wordsetdao; }
	 */

	public void insert(WordSet wordSet) {
		worddao.insertWord( wordSet);
		
	}

}
