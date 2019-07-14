package com.ingroinfo.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ingroinfo.hibernate.demo.entitiy.Student;

public class PrimaryKeyDemo {

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
					Student tempStudent1=new Student("sanu","sekh","sanu@gmail.com");
					Student tempStudent2=new Student("monu","siddiqui","manu@gmail.com");
					Student tempStudent3=new Student("waqeel","ahmad","waqeel@gmail.com");
					Student tempStudent4=new Student("shakeel","mirza","shakeel@gmail.com");
					
					//begin the transaction
					session.beginTransaction();
					
					//saving the object
					System.out.println("Saving the Object");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					session.save(tempStudent4);
					
					//commit transaction
					
					session.getTransaction().commit();
					System.out.println("Done");
					
					
				}finally {
					
					sessionFactory.close();
				}

			}

	}


