package hello.core;

import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {

	public static void main(String[] args) {
		AppConfig appConfig = new AppConfig();
		MemberService ms = appConfig.memberService();
		OrderService os = appConfig.orderService();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		ms.join(member);
		
		Order order = os.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order.calculatePrice());
	}
}
