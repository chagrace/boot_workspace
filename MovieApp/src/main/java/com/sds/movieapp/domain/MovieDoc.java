package com.sds.movieapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="movie")
public class MovieDoc {

	@Id
	private String id;
	
	private int movie_idx;
	
	//영화추천에 필요한 필드
	private String[] genres;
	private String movieNm;
	private String[] directors;
	private String[] actors;
	private String[] nations;
	private String content;
}
