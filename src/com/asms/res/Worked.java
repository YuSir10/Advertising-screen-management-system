package com.asms.res;
/**
 *  Ù–‘¿‡£¨
 * @author –§Ÿª
 *
 */
public class Worked {
	private String name;
	private String ip;
	private String ord;
	private String time;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOrd() {
		return ord;
	}
	public void setOrd(String ord) {
		this.ord = ord;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Worked() {
		super();
	}
	public Worked(String name,String ip,String ord,String time){
		this.name = name;
		this.ip = ip;
		this.ord = ord;
		this.time = time;
	}
}
