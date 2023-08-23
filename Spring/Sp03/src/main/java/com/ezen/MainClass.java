package com.ezen;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ezen.battery.ChargeBattery;
import com.ezen.battery.NormalBattery;
import com.ezen.toy.ElectronicCar;
import com.ezen.toy.ElectronicRadio;

public class MainClass {

	public static void main(String[] args) {
	
		// 일반적인 사용에
		// 노멀 배터리가 장착된 상태로 판매되는 일체형. 객체생성 하나만으로 사용이 가능함
		ElectronicCar carToy1 = new ElectronicCar();
		
		// ElectronicRadio radioToy = new 	ElectronicRadio(); // 에러

		NormalBattery nbatt1 = new NormalBattery();
		ChargeBattery cbatt1 = new ChargeBattery();
		ElectronicRadio radioToy1 = new ElectronicRadio( nbatt1 );
		ElectronicRadio radioToy2 = new ElectronicRadio( cbatt1);
		// 생성자에 배터리 객체를 전달해주면 정상 객체 생성.
		// 이렇게 객체 생성시에 다른 객체의 존재 및 생성자로의 전달이 꼭 필요한 상태!
		// 객체 생성이 다른 객체에 의존하고 있는 상태! 이를 객체 의존이라고 부름
		// 그리고 필요 객체를 생성자의 전달인수로 넣어 주는 것을 의존 주입(Dependency Injection) 이라고 부름.
		
		// 객체 의존 주입(Dependency Injection, DI)은 소프트웨어 공학에서 사용되는 디자인 패턴입니다. 
		// DI는 클래스 간의 의존 관계를 외부에서 주입하여 결합도를 낮추고 유연성과 재사용성을 향상시킵니다.
        // 일반적으로 클래스는 다른 클래스나 객체에 의존성을 가집니다. 의존성은 한 클래스가 다른 클래스를 사용하거나, 다른 클래스의 인스턴스를 생성하거나, 다른 클래스의 메서드를 호출하는 등의 형태로 나타납니다. 이러한 의존성을 관리하는 일은 클래스 내에서 처리될 수도 있지만, 
        // DI는 이러한 의존성을 외부에서 주입함으로써 클래스가 더 독립적이고 재사용 가능하게 만듭니다.
        // DI는 일반적으로 세 가지 주요 형태로 사용됩니다:
        // 생성자 주입(Constructor Injection): 클래스의 생성자를 통해 의존하는 객체를 주입하는 방식입니다.
        // setter 주입(Setter Injection): setter 메서드를 사용하여 의존 객체를 주입하는 방식입니다.
        // 인터페이스 주입(Interface Injection): 의존하는 객체를 구현한 인터페이스를 통해 주입하는 방식입니다.
        // DI를 사용하면 의존성을 관리하기 위한 코드가 클래스 내에 존재하지 않으므로 클래스가 더 단순하고 유연해집니다. 또한, DI 컨테이너를 사용하여 의존 객체를 관리하고 주입하는 작업을 자동화할 수 있습니다.
        // DI는 코드의 테스트 용이성과 모듈화를 개선하는 데 도움이 되므로, 대규모 애플리케이션 개발에서 많이 사용되는 패턴입니다.
		
		GenericXmlApplicationContext ctx
        = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		ElectronicCar carToy3 = ctx.getBean("car",ElectronicCar.class);
		ElectronicRadio radioToy3 = ctx.getBean("radio",ElectronicRadio.class);
		radioToy2.setBattery(nbatt1);
		
		ctx.close();
		
	}

}
