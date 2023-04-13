package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링 없는 순수한 di 컨테이너")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		//1. 조회: 호출 마다 객체 생성
		MemberService memberService1 = appConfig.memberService();
		
		//2. 조회: 호출 마다 객체 생성
		MemberService memberService2 = appConfig.memberService();
		
		//참조값이 다른 것을 확인
		System.out.println("1 = " + memberService1);
		System.out.println("2 = " + memberService2);
		
		// memberService1 != memberService2
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
	}
	
	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		SingletonService ss1 = SingletonService.getInstance();
		SingletonService ss2 = SingletonService.getInstance();
		
		System.out.println("ss1 = " + ss1);
		System.out.println("ss2 = " + ss2);
		
		Assertions.assertThat(ss1).isSameAs(ss2);
	}
}
