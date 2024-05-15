package com.sds.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sds.movieapp.sns.KaKaoLogin;
import com.sds.movieapp.sns.NaverLogin;

@RestController
public class RestMemberController {
	
	@Autowired
	private NaverLogin naverLogin;
	
	@Autowired
	private KaKaoLogin kakaoLogin;
	
	@GetMapping("/rest/member/authform/{sns}")
	public ResponseEntity getLink(@PathVariable("sns") String sns) {
		ResponseEntity entity =null;
		
		if(sns.equals("google")) {
			//entity = ResponseEntity.ok(naverLogin.getGrantUrl());
		}else if(sns.equals("naver")) {
			entity = ResponseEntity.ok(naverLogin.getGrantUrl());
		}else if(sns.equals("kakao")) {
			entity = ResponseEntity.ok(kakaoLogin.getGrantUrl());
		}
		
		return entity;
	}

}