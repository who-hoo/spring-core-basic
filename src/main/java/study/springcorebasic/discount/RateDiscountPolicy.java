package study.springcorebasic.discount;

import org.springframework.stereotype.Component;
import study.springcorebasic.annotation.MainDiscountPolicy;
import study.springcorebasic.member.Grade;
import study.springcorebasic.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    private boolean isVip(Member member) {
        return member.getGrade() == Grade.VIP;
    }

    @Override
    public int discount(Member member, int price) {
        if (isVip(member)) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
