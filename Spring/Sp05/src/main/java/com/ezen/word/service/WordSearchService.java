package com.ezen.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordSetDao;
import com.ezen.word.dto.WordSet;

public class WordSearchService {

	@Autowired
	WordSetDao worddao;

	public WordSet searchWord(String input) {	
		return worddao.searchWord( input);
	}
	
	
	
}
