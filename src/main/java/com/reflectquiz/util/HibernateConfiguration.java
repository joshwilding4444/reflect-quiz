package com.reflectquiz.util;

import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateConfiguration {
	private static SessionFactory ssnfctry;
	
	public static Session getSession() {
		InputStream stream = null;
		Properties props = new Properties();
		
		try {
			if(ssnfctry == null) {
				stream = HibernateConfiguration.class.getResourceAsStream("/application.properties");
				props.load(stream);
				Class.forName("org.postgresql.Driver");
				ssnfctry = new Configuration().configure()
						.setProperty("hibernate.connection.url", props.getProperty("url"))
						.setProperty("hibernate.connection.username", props.getProperty("username"))
						.setProperty("hibernate.connection.password", props.getProperty("password")).buildSessionFactory();
			}
			if( stream != null ) stream.close();
			return ssnfctry.getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
