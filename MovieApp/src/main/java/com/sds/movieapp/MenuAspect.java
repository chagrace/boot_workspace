package com.sds.movieapp;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sds.movieapp.model.movie.MovieService;

import jakarta.servlet.http.HttpServletRequest;

//스프링 mvc에서는 xml 파일에서 빈을 설정할 수 있었지만, 스프링부트에서는
//@Configuration 클래스에서 담당한다, 따라서 아래의 클래스를 Aspect로 등록하여 aop를 구현해보자
@Aspect
@Component
public class MenuAspect {
	
	@Autowired
	private MovieService movieService;

	//모든 컨트롤러 대상으로 aop가 실행됨
	@Pointcut("execution(public * com.sds.movieapp.controller..*(..))")
	public void includeExecution() {}
	
	//얘네는 aop코드 적용 안함
	@Pointcut("!execution(public * com.sds.movieapp.controller.Rest*Controller.*(..))")
	public void excludeExecution() {}
	
	@Around("includeExecution() && excludeExecution() ")
	public Object getMenu(ProceedingJoinPoint joinPoint) throws Throwable{
		Object obj = null;
		obj = joinPoint.proceed(); //대표컨트롤러가 원래 호출하려던, 바로 그 하위 컨트롤러의 메서드를 호출
		//하위 컨트롤러들의 메서드는 String or ModelAndView를 반환함
		
		List movieTypeList = movieService.getMovieTypeList();
		
		ServletRequestAttributes attr =(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		request.setAttribute("movieTypeList", movieTypeList);
		
		return obj;
	}
}
