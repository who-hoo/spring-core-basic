package study.springcorebasic.order;

import study.springcorebasic.discount.DiscountPolicy;
import study.springcorebasic.discount.FixDiscountPolicy;
import study.springcorebasic.member.Member;
import study.springcorebasic.member.MemberRepository;
import study.springcorebasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
