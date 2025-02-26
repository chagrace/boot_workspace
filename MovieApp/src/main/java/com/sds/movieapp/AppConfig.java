package com.sds.movieapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;

/*
 * Spring 3.0부터 스프링 설정 xml을 대신 할 어노테이션을 지원함
 */
@Configuration
public class AppConfig { //root-context.xml을 대신함
	@Bean
	public String key() {
		return "35d03b814e6bd53015879bb0f646b1b7";
	}
	
	@Bean
	public KobisOpenAPIRestService kobisOpenAPIRestService(String key) {
		
		return new KobisOpenAPIRestService(key);
	}
	
	@Bean
	public Komoran komoran() {
		String modelPath=null;
		try {
			modelPath = new ClassPathResource("model_light").getFile().getAbsolutePath();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Komoran(modelPath); //분석 정보가 들어있는 데이터의 위치 경로
	}
}
