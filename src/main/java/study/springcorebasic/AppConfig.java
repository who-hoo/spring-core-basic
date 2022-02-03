package study.springcorebasic;

import study.springcorebasic.discount.DiscountPolicy;
import study.springcorebasic.discount.RateDiscountPolicy;
import study.springcorebasic.member.MemberRepository;
import study.springcorebasic.member.MemberService;
import study.springcorebasic.member.MemberServiceImpl;
import study.springcorebasic.member.MemoryMemberRepository;
import study.springcorebasic.order.OrderService;
import study.springcorebasic.order.OrderServiceImpl;

public class AppConfig {

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
