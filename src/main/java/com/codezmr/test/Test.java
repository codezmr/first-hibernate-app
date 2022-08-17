package com.codezmr.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.codezmr.entity.Employee;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction transaction = null;
		
		try {
			
			Configuration cfg = new Configuration();
			System.out.println("--------------> cfg created");
			
			cfg.configure("hibernate.cfg.xml");
			System.out.println("--------------> cfg configured");
			
			sessionFactory = cfg.buildSessionFactory();
			System.out.println("--------------> sessionFaactory initialized");
			
			session = sessionFactory.openSession();
			System.out.println("--------------> initialized session");
			
			transaction = session.beginTransaction();
			System.out.println("--------------> transaction initialized");
			
			Employee emp = new Employee();
			emp.setEno(112);
			emp.setEname("Zamiruddin");
			emp.setEsal(70000);
			emp.setEaddr("IN");
			System.out.println("-----------------> emp initialzed");
			
			session.save(emp);
			System.out.println("------------------> session save sucess");
			
			transaction.commit();
			System.out.println("------------------> transaction committed.");
			System.out.println("------------------> Employee inserted success....");
			System.out.println("Transaction success...........");
		}catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			System.out.println("---------------->Trnasaction failure.");
			
			
		} finally {
			
			session.close();
			sessionFactory.close();
		}
	}
}
