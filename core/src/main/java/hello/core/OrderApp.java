package hello.core;

import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class OrderApp {

	public static void main(String[] args) {
		MemberService ms = new MemberServiceImpl();
		OrderService os = new OrderServiceImpl();
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		ms.join(member);
		
		Order order = os.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order.calculatePrice());
	}
}
