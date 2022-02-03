package study.springcorebasic;

import study.springcorebasic.discount.FixDiscountPolicy;
import study.springcorebasic.member.MemberService;
import study.springcorebasic.member.MemberServiceImpl;
import study.springcorebasic.member.MemoryMemberRepository;
import study.springcorebasic.order.OrderService;
import study.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
