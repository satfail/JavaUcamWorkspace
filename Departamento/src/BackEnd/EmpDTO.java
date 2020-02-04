package BackEnd;

import java.sql.Date;

public class EmpDTO {
	
	private int depno;
	private int empno;
	private String ename;
	private Date hiredate;
	
	public String toString() {
		return  empno + ", " + ename + ", " + hiredate + " ," + depno;
	}
	public int getEmpno() {
		return empno;
	}
	
	public void setEmpno(int empno) {
		
		this.empno = empno;
	}

	public int getDepno() {
		return depno;
	}
	
	public void setDepno(int depno) {
		
		this.depno = depno;
	}
	public String getEname() {
		return ename;
	}
	
	public void setEname(String ename) {
		
		this.ename = ename;
	}
	public Date getDate() {
		return hiredate;
	}
	
	public void setDate(Date hiredate) {
		
		this.hiredate = hiredate;
	}
}

