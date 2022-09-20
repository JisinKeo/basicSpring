package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;


// @Configuration 설정을 구성한다는 뜻
// 각 메서드에 @Bean을 붙여 스프링 컨테이너에 스프링 빈으로 등록한다
public class AppConfig { //애플리케이션의 전체 동작 방식을 구성하기 위해, 역할과 구현 클래스가 한눈에 들어온다.

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
