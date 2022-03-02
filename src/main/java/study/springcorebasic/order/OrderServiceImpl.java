package study.springcorebasic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import study.springcorebasic.discount.DiscountPolicy;
import study.springcorebasic.member.Member;
import study.springcorebasic.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
