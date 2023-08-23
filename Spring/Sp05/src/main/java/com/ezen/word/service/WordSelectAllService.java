package com.ezen.word.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordSetDao;
import com.ezen.word.dto.WordSet;



public class WordSelectAllService {
	
	@Autowired
	WordSetDao worddao;

	public ArrayList<WordSet> SelectAll() {
		return worddao.wordSelectAll();
	
	}
		
	
}
