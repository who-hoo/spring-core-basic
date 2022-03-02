package study.springcorebasic.discount;

import org.springframework.stereotype.Component;
import study.springcorebasic.member.Grade;
import study.springcorebasic.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;

    private boolean isVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }

    @Override
    public int discount(Member member, int price) {
        if (isVip(member)) {
            return discountFixAmount;
        }
        return 0;
    }
}
