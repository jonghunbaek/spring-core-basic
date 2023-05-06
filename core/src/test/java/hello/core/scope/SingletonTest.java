package hello.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class SingletonTest {

	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);
		
		SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
		SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
		System.out.println("single1 = " + singletonBean1);
		System.out.println("single2 = " + singletonBean2);
		Assertions.assertThat(singletonBean1).isEqualTo(singletonBean2);
		
		ac.close();
	}
	
	@Scope("singleton")
	static class SingletonBean {
		@PostConstruct
		public void init() {
			System.out.println("SingletonBean.init");
		}
		
		@PreDestroy
		public void destroy() {
			System.out.println("SingletonBean.destroy");
		}
	}
}