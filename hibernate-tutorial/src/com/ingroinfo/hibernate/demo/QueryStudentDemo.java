package com.ingroinfo.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		try {
			 
			
			//begin the transaction
			session.beginTransaction();
			
			List<Student> myStudents=session.createQuery("from Student").list();
			
			displayStudents(myStudents);
			
			myStudents=session.createQuery("from Student s where s.lastName='siddiqui'").list();
			
			System.out.println("\n\n\nthe Students who has last Name Siddiqui:---");
			
			displayStudents(myStudents);
			
			
			myStudents=session.createQuery("from Student s where s.lastName='siddiqui' OR s.firstName='shakeel'").list();
			
             System.out.println("\n\n\nthe Students who has last Name Siddiqui or firstName=: shakeel");
			
			displayStudents(myStudents);
			
			myStudents=session.createQuery("from Student s where s.email LIKE '%gmail.com'").list();
			
			System.out.println("\n\n\nmail rnds with gmail.com");
			
			displayStudents(myStudents);
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

	private static void displayStudents(List<Student> myStudents) {
		for(Student tempStudent:myStudents) {
			System.out.println(tempStudent);
			
		}
	}

}
