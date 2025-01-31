package com.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateUtil;
import com.model.Employee;

public class TestMain {
	
	public static void main(String[] args) {
	
	SessionFactory factory = HibernateUtil.getSessionFactrory();
	Session session = factory.openSession();
	Scanner s = new Scanner(System.in);
	
	System.out.println("Enter your Choice:");
	System.out.println("1.Insert \n2.Get \n3.Delete \n4.Update \n5.Exit");
	
	switch(s.nextInt()) {
	case 1:
		inserRecord(session,s);
		break;
		
	case 2:
		getRecord(session,s);
		break;
		
	case 3:
		deleteRecord(session,s);
		break;
		
	case 4:
		updateRecord(session,s);
		break;
	
	case 5:
		System.exit(5);
		break;
		
	default :
		System.out.println("Enter valid NO :");
		break;
		
	}
}
	private static void getRecord(Session session, Scanner s) {
		// TODO Auto-generated method stub
		System.out.println("Enter Eid to Get Record..!");
		Employee emp = session.get(Employee.class,s.nextInt());
		System.out.println(emp);
		
	}
	private static void inserRecord(Session session, Scanner s) {
	
		Transaction txn = session.beginTransaction();
		System.out.println("Enter Eid to Insert Record");
		Employee emp = new Employee();
		
		System.out.println("Enter Eid");
		emp.setEid(s.nextInt());
		
		System.out.println("Enter Ename");
		emp.setEname(s.next());
		
		System.out.println("Enter Salary");
		emp.setSalary(s.nextDouble());
		
		System.out.println("Enter Mobile NO");
		emp.setMono(s.nextLong());
		
		session.save(emp);
		txn.commit();
		System.out.println("Employee Added...!");
		
	}
	private static void updateRecord(Session session,Scanner s) {
		Transaction txn = session.beginTransaction();
		System.out.println("Enter Eid to update Records..!");
		Employee emp = session.get(Employee.class,s.nextInt());
		
		System.out.println("Enetr new name");
		emp.setEname(s.next());
		
		System.out.println("Enter new salary");
		emp.setSalary(s.nextDouble());
		
		System.out.println("Enter new mobile no");
		emp.setMono(s.nextLong());;
		
		session.update(emp);
		txn.commit();
		System.out.println("Employee updated..!");
	}
	
	private static void deleteRecord(Session session,Scanner s) {
		Transaction txn = session.beginTransaction();
		System.out.println("Enter Eid to delete Record..!");
		Employee emp = session.get(Employee.class,s.nextInt());
		
		session.update(emp);
		txn.commit();
		System.out.println("Employee deleted..!");
	}
}
