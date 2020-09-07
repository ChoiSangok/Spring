package test03;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;

public class MyAdvice{

   //JoinPoint타겟객체에 대한 정보를 담고있다
      //스프링에서 AOP를 사용하기 위해서 반드시 매개변수로 넣어줘야 하는 객체
   public void before(JoinPoint join) {
	   
	  //클래스명
      System.out.println(join.getTarget().getClass());
      //메서드 이름
      System.out.println(join.getSignature());
      //대상 객체 메서드의 정보
      System.out.println(join);
      //메소드 매개변수
      System.out.println(join.getArgs());
      
      
      
      System.out.println("출석카드를 찍는다.");
   }
   public void after(JoinPoint join) {
      System.out.println("집에 간다.");
   }
   
}
