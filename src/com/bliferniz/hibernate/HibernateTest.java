/**
 * 
 */
package com.bliferniz.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bliferniz.dto.FourWheeler;
import com.bliferniz.dto.TwoWheeler;
import com.bliferniz.dto.Vehicle;

/**
 * @author Vitalij Bliferniz
 *
 */
public class HibernateTest {

	private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");

		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche steering wheel");
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		session.save(vehicle);
		session.save(bike);
		session.save(car);
		
		
		transaction.commit();
		session.close();
		
	}
	
}
