package com.asms.res;
/**
 * ÊôĞÔÀà£¬
 * @author Ğ¤Ù»
 *
 */
public class Worked {
	private String managername;
	private String instructname;
	private String advtime;
	private String ipadress;
	
	
	
	
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getInstructname() {
		return instructname;
	}
	public void setInstructname(String instructname) {
		this.instructname = instructname;
	}
	public String getAdvtime() {
		return advtime;
	}
	public void setAdvtime(String advtime) {
		this.advtime = advtime;
	}
	public String getIpadress() {
		return ipadress;
	}
	public void setIpadress(String ipadress) {
		this.ipadress = ipadress;
	}
	public Worked() {
		super();
	}
	public Worked(String managername,String instructname,String advtime,String ipadress){
		this.managername = managername;
		this.instructname = instructname;
		this.advtime = advtime;
		this.ipadress = ipadress;
	}
	
}
