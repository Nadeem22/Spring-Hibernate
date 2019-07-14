package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Student;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		try {
			 
			
		
			int studentId=1;
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGettting Student by Id:-" +studentId);
			
			Student myStudent=session.get(Student.class,studentId);
			
			System.out.println(myStudent);
			System.out.println("\n\nUpdating Student:-");
			
			myStudent.setFirstName("Lallan");
			
			session.getTransaction().commit();
			
			System.out.println("update Completed" +myStudent);
			
			System.out.println("Done");
			
			
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			System.out.println("updating Emails");
			session.createQuery("update Student set email='ndls@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
