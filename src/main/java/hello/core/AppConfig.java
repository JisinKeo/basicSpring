package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// @Configuration 설정을 구성한다는 뜻
// 각 메서드에 @Bean을 붙여 스프링 컨테이너에 스프링 빈으로 등록한다

// 스프링 컨테이너 : ApplicationContext , 자바 객체의 생명 주기를 관리하며 생성된 자바 객체들에게 추가적인 기능을 제공
// Bean : 컨테이너 안에 들어있는 객체
// DI : 의존성 주입, 컨테이너가 의존관계를 자동으로 연결
// Ioc : 제어권이 사용자에게 있지 않고 프레임워크에 있음


@Configuration
public class AppConfig { //애플리케이션의 전체 동작 방식을 구성하기 위해, 역할과 구현 클래스가 한눈에 들어온다.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//       return new FixDiscountPolicy();
        return new RateDiscountPolicy();
        // 할인 정책을 변경해도, 애플리케이션의 구성 역할을 담당하는 AppConfig만 변경하면 된다.
    }

}
