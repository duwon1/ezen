package com.ezen.toy;

import com.ezen.battery.Battery;

public class ElectronicRadio {
  
	 private Battery bat;
	 
	 public ElectronicRadio( Battery battery) {
		// bat = new NormalBattery();
		// bat = new ChargeBattery();
		 this.bat = battery;  // 손에 잡힌 배터리가 최초 장착된 배터리가 됨.
	 }
	 
	 public void setBattery( Battery battery) {
		 this.bat = battery;
	 } // 추 후 배터리를 새로 교체 할 수 있는 기능이 있음.
	 
	 
}
// 구매와 동시에 동봉되어 있거나, 또는 별도 구입한 새 배터리를 장착할 수 있는 기능이 있음
