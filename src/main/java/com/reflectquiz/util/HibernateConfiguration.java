package com.reflectquiz.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class HibernateConfiguration {
	private static SessionFactory ssnfctry;
	
	public static Session getSession() {
		try {
			if(ssnfctry == null) {
				Properties creds = new Properties();
				InputStream credStream = HibernateConfiguration.class
						.getResourceAsStream("/application.properties");
				creds.load(credStream); 
				ssnfctry = new Configuration().configure()
						        .setProperty("hibernate.connection.url", 
						        					creds.getProperty("url"))
						        .setProperty("hibernate.connection.username", 
						        					creds.getProperty("username"))
						        .setProperty("hibernate.connection.password", 
						        					creds.getProperty("password"))
						        .buildSessionFactory();
			}
			return ssnfctry.getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
