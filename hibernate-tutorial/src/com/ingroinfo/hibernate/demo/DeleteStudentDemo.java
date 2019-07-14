package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Student;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create Session Factory
		
		SessionFactory sessionFactory=new Configuration()
				.configure()
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create a session
		
		Session session= sessionFactory.getCurrentSession();
		try {
			 
			
		/*
			int studentId=1;
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGettting Student by Id:-" +studentId);
			
			Student myStudent=session.get(Student.class,studentId);
			
			System.out.println(myStudent);
			System.out.println("\n\nDeleting Student:-");
			
			session.delete(myStudent);
			
			session.getTransaction().commit();*/
		
			
			System.out.println("Done");
			
			session=sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id=2").executeUpdate();
			session.getTransaction().commit();
			
			
			
		}finally {
			
			sessionFactory.close();
		}

	}

}
