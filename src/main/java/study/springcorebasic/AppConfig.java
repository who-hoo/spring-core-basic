package study.springcorebasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.springcorebasic.discount.DiscountPolicy;
import study.springcorebasic.discount.RateDiscountPolicy;
import study.springcorebasic.member.MemberRepository;
import study.springcorebasic.member.MemberService;
import study.springcorebasic.member.MemberServiceImpl;
import study.springcorebasic.member.MemoryMemberRepository;
import study.springcorebasic.order.OrderService;
import study.springcorebasic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
