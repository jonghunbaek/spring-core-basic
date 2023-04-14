package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService s1 = ac.getBean(StatefulService.class);
		StatefulService s2 = ac.getBean(StatefulService.class);
		
		// ThreadA : A사용자 10000원 주문
		int userAprice = s1.order("userA", 10000);
		// ThreadB : B사용자 10000원 주문
		int userBprice = s2.order("userB", 20000);
		
		// ThreadA : A사용자 주문 금액 조회
		//int price = s1.getPrice();
		System.out.println("price = " + userAprice);
		
		//Assertions.assertThat(s1.getPrice()).isEqualTo(20000);
	}
	
	static class TestConfig {
		
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
