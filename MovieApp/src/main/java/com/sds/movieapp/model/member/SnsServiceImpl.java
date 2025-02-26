package com.sds.movieapp.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.Sns;

@Service
public class SnsServiceImpl implements SnsService{

	@Autowired
	private SnsDAO snsDAO;
	
	@Override
	public Sns selectByName(String sns_name) {
		
		return snsDAO.selectByName(sns_name);
	}

}
