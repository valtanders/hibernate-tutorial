package com.bruno.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bruno.hibernate.demo.entity.Instructor;
import com.bruno.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {					
			// create the objects
//			Instructor instructor = new Instructor("Bruno", "Bollati", "bbollati@temperies.co");
			
//			InstructorDetail instructorDetail = new InstructorDetail("Valtanders", "gamming hard");
			
			Instructor instructor = new Instructor("Marcela", "Mashe", "mashe@temperies.co");
			
			InstructorDetail instructorDetail = new InstructorDetail("Cole 51", "plants");
			
			// associate the objects
			
			instructor.setInstructorDetail(instructorDetail);
			
			// start the student object
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save de details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving Instructor: " + instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}

}
