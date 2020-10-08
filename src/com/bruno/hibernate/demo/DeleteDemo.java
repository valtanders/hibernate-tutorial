package com.bruno.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bruno.hibernate.demo.entity.Instructor;
import com.bruno.hibernate.demo.entity.InstructorDetail;
import com.bruno.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();

		try {
			// start transaction
			session.beginTransaction();

			// get instructor by primary key / id
			Instructor theInstructor = session.get(Instructor.class, 1);
			System.out.println(theInstructor);

			// delete the intrusctor
			if (theInstructor != null) {
				System.out.println("Deleting: " + theInstructor);
				
				// Note: will ALSO delete associated "detail" object
				// because of CascadeType.ALL
				//
				session.delete(theInstructor);
			}

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");

		} finally {
			factory.close();
		}
	}

}
