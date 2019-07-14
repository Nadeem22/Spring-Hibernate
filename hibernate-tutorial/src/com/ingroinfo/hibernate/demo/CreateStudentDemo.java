package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		try {
			 
			//creating the Student Object
			System.out.println("creating the student object...");
			Student tempStudent=new Student("nadeem","siddiqui","nadeem2107@gmail.com");
			
			//begin the transaction
			session.beginTransaction();
			
			//saving the object
			System.out.println("Saving the Object");
			session.save(tempStudent);
			
			//commit transaction
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
