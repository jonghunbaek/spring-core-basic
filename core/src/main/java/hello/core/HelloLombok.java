package hello.core;

import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Getter
@Setter
@ToString
public class HelloLombok {

	private String name;
	private int age;
	
	public static void main(String[] args) {
		HelloLombok hello1 = new HelloLombok();
		hello1.setName("abc");
		
		String name = hello1.getName();
		System.out.println(hello1);
	}
}
