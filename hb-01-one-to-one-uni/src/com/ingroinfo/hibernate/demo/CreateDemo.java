package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Instructor;
import com.ingroinfo.hibernate.demo.entitiy.InstructorDetail;
import com.ingroinfo.hibernate.demo.entitiy.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		try {
			
			Instructor tempInstructor=new Instructor("nadeem" ,"siddiqui", "nadeem@gmail.com");
			
			InstructorDetail tempInstructorDetail=new InstructorDetail("nadeem/youtube.com","codeing");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//begin the transaction
			session.beginTransaction();
			System.out.println(tempInstructor);
			session.save(tempInstructor);
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
