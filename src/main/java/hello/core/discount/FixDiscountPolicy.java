package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;




// 조회 대상 빈이 2개 이상일때 해결 방법
// 1. @Autowired 필드 명 매칭 : 타입 매칭을 시도하고, 여러 빈이 있으면 필드 이름, 파라미터 이름으로 빈 이름을 추가 매칭한다.
// 2. @Quilifier -> @ Quilifier 끼리 매칭 -> 빈 이름 매칭
// 3. @Primary 사용
// Qualifier : 추가 구분자를 붙여주는 방법이다. 주입시 추가적인 방법을 제공하는 것이지 빈 이름을 변경하는 것은 아니다.
@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else{
            return 0;
        }
    }
}
