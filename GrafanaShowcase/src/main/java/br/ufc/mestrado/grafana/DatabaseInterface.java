package br.ufc.mestrado.grafana;

import java.util.Calendar;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DatabaseInterface {
	protected SessionFactory sessionFactory;
	
	public DatabaseInterface() {
		this.setup();
	}
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        .configure() // configures settings from hibernate.cfg.xml
		        .build();
		try {
		    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
		    StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
	public void exit() {
		this.sessionFactory.close();
	}
	
	/**
	 * Generates an entry for Grafana with the current timestamp
	 * and a random value between valueFloor and valueCeiling.
	 * 
	 * @param valueFloor min value to generate.
	 * @param valueCeiling max value to generate.
	 */
	protected void createRandom(int valueFloor, int valueCeiling) {
	    GrafanaData entry = new GrafanaData();
	    
	    Calendar calendar = Calendar.getInstance();
	    java.util.Date now = calendar.getTime();
	    java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
	    
	    Random rand = new Random();
	    int  n = rand.nextInt(valueCeiling - valueFloor) + 1;
	    
	    entry.setSavedHour(currentTimestamp);
	    entry.setValue(n);
	    
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    session.save(entry);
	 
	    session.getTransaction().commit();
	    session.close();
	}

}
