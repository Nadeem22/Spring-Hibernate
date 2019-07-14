package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Instructor;
import com.ingroinfo.hibernate.demo.entitiy.InstructorDetail;

public class GetInstructorDetailDemo {

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
			
			InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);
			
			System.out.println("Instructor Detail :-" +tempInstructorDetail);
			
			System.out.println("Instructor Detail :-" +tempInstructorDetail.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
