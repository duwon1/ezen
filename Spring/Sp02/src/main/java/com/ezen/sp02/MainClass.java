package com.ezen.sp02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		
		// 일반적인 클래스의 객체 생성 및 메서드 호출의 예
		WalkClass wk = new WalkClass();
		wk.move();
       
		// 스프링 프레임 워크에서는 클래스의 객체 생성 및 운영이 다르게 운영됨.
		// 위처럼 필요할 때 new 인스턴스를 생성하지 않고, 프로그램 시작 시에 미리 생성 & 보관하고 있다가, 필요할 때 
		// 꺼내쓰는 방법을 사용함.
		
		// 만들어진 인스턴스의 보관장소를 "스프링 컨테이너" 라고 부름.
		// 현재 프로젝트에서 사용할 스프링 컨테이너는 applicationContext.xml임.
		// applicationContext.xml 은 기본 위치가 src/main/resources 폴더가 됨.
		
		// 스프링 컨테이너에 담겨 있는 객체들을 Bean 이라고 부름.
		// 스프링 컨테이너에 담겨 있는  빈을 필요할 때 꺼내 쓰려면 아래와 같이 컨테이너의 사용권한을 갖고 있는 객체를 생성하여 사용함.
		GenericXmlApplicationContext ctx
        = new GenericXmlApplicationContext("classpath:applicationContext.xml");
       // 스프링 컨테이너에서 빈을 꺼내 쓸 수 있는 기능이 있는 객체를 생성함"	
		
		// 꺼내는 방법은 기존 new 인스턴스를 레퍼런스 변수에 저장하듯. ctx로 꺼낸 빈을 레퍼런스 변수에 저장하듯 사용함.
		WalkClass wc2 = ctx.getBean("cWalk", WalkClass.class);
		// cWalk: 스프링 컨테이너 내부에 있는 그 클래스의 id값
	    // WalkClass.class: 스프링 컨테이너 내부에 있는 그 클래스의 이름
		
		wc2.move();
		ctx.close();
		
		// 아직까지 일반 자바 프로젝트에서 사용하는 new WalkClass()와 사용한 차이점은 없어 보이기도 하고 오히려 더 불편해보임.
		// 차이점은 , new 인스턴스를 사용하면 사용할때마다, 새로운 인스턴스가 생성되는 반면
		// getBean()은 싱글턴 방식처럼 하나의 생성된 객체가 계속 사용된다는 점이 다름.
		// getBean()으로 같은 클래스의 서로 다른 인스턴스를 두 개 사용해야한다면, 다른 id값을 Bean을 하나 더 추가해서 사용함.
		// <bean class="com.ezen.spcon.WalkClass" id="cWalk2"></bean>
		
		
	}

}
