package BackEnd;

public class DeptDTO {  ///DTO son los setters y getters
	
	public int depno;
	private String dname;
	private String loc;
	
	public String toString() {
		return  depno + ", " + dname + ", " + loc;
	}

	public int getDepno() {
		return depno;
	}
	
	public void setDepno(int depno) {
		
		this.depno = depno;
	}
	public String getDname() {
		return dname;
	}
	
	public void setDname(String dname) {
		
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	
	public void setLoc(String loc) {
		
		this.loc = loc;
	}
}
