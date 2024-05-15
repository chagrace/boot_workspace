package com.sds.testapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//아래의 어노테이션이 많은 어노테이션들을 포함하고있기때문에
//spring legacy mvc 에서 개발자가 일일이 등록해야 할 각종 설정들이 이제는 불필요
//@service, @repository 등등 모두 자동으로 올림 component-scan 기능이 포함
@SpringBootApplication
public class TestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

}
