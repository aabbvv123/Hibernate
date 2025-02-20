
package com.model;
import javax.persistence.Entity;
import javax.persistence.Id;
	
	@Entity
	public class Employee {
		
		@Id
		private int eid;
		private String ename;
		private double salary;
		private long mno;
		
		public int getEid() {
			return eid;
		}
		public void setEid(int eid) {
			this.eid = eid;
		}
		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public long getMno() {
			return mno;
		}
		public void setMno(long mno) {
			this.mno = mno;
			
			
		}
		@Override
		public String toString() {
			return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + ", mno=" + mno + "]";
		}
	

}
