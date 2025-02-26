package com.sds.movieapp.model.movie;

import java.util.List;
import java.util.Map;

import com.sds.movieapp.domain.Movie;

public interface MovieService {
	public int selectCount();
	public List selectAll(Map map);
	public Movie select(int movie_idx);
	public List getMovieTypeList();
	
}
