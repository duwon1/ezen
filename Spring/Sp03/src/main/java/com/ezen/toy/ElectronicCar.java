package com.ezen.toy;

import com.ezen.battery.Battery;
import com.ezen.battery.NormalBattery;

public class ElectronicCar {

	// 인터페이스 레퍼런스 변수. = NormalBattery 또는 ChargeBattery 인스턴스가 저장될 변수 (배터리 소켓 역할)
	private Battery bat;
	
	public ElectronicCar() {
		// 생성자에서 노멀 베터리를 멤버변수에 초기값으로 대입하고 시작함. 배터리 교체 불가능
		bat = new NormalBattery();
	}
	
}
// 이 장난감은 배터리가 출시 당시 탑재(내장) 되어서 교체가 불가능한 상태로 판매되는 형태임.