package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Instructor;
import com.ingroinfo.hibernate.demo.entitiy.InstructorDetail;
import com.ingroinfo.hibernate.demo.entitiy.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			
			int theId=1;
			
			Instructor tempInstructor=session.get(Instructor.class,theId);
			
			System.out.println("Instructor Found" +tempInstructor);
			
			if(tempInstructor!=null) {
				System.out.println("deleting temInstructor" +tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			//begin the transaction
			
			
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
