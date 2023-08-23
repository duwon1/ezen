package com.ezen.member.dto;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EMSInformationService {

	private String info;
	private String copyRight;
	private String ver;
	private String sYear;
	private String sMonth;
	private String sDay;
	private String eYear;
	private String eMonth;
	private String eDay;
	private List <String> developers;
	private Map <String, String> administators;
	private Map <String, DataBaseConnectionInfo> dbInfos;
	
	public void outputEMSInformation(){
		System.out.print("\n\n");
		String devPeriod=sYear+"/"+sMonth+"/"+sDay+" ~ "+eYear+"/"+eMonth+"/"+eDay;
		System.out.println(info + "(" + devPeriod + ")" + "\n" + copyRight + "\n" + ver);
		System.out.println("Developers : " + developers);
		System.out.println("Administrator : " + administators);
		outputDataBaseInfo();  // 아래 메서드 호출
		System.out.print("\n\n");
	}
	private void outputDataBaseInfo() {
		Set<String> keys = dbInfos.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			DataBaseConnectionInfo info = dbInfos.get(key);
			System.out.printf("[%s]", key);
			System.out.print("jdbcUrl:" + info.getUrl() + "\t");
			System.out.print("userId:" + info.getId() + "\t");
			System.out.print("userPw:" + info.getPw() + "\n");
		}
	}
	
	
	
	
	
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getCopyRight() {
		return copyRight;
	}
	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getsYear() {
		return sYear;
	}
	public void setsYear(String sYear) {
		this.sYear = sYear;
	}
	public String getsMonth() {
		return sMonth;
	}
	public void setsMonth(String sMonth) {
		this.sMonth = sMonth;
	}
	public String getsDay() {
		return sDay;
	}
	public void setsDay(String sDay) {
		this.sDay = sDay;
	}
	public String geteYear() {
		return eYear;
	}
	public void seteYear(String eYear) {
		this.eYear = eYear;
	}
	public String geteMonth() {
		return eMonth;
	}
	public void seteMonth(String eMonth) {
		this.eMonth = eMonth;
	}
	public String geteDay() {
		return eDay;
	}
	public void seteDay(String eDay) {
		this.eDay = eDay;
	}
	public List<String> getDevelopers() {
		return developers;
	}
	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
	public Map<String, String> getAdministators() {
		return administators;
	}
	public void setAdministators(Map<String, String> administators) {
		this.administators = administators;
	}
	public Map<String, DataBaseConnectionInfo> getDbInfos() {
		return dbInfos;
	}
	public void setDbInfos(Map<String, DataBaseConnectionInfo> dbInfos) {
		this.dbInfos = dbInfos;
	}

	
	
}
