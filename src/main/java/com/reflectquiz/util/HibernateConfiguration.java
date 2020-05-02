package com.reflectquiz.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateConfiguration {
	private static SessionFactory ssnfctry;
	
	public static Session getSession() {
		try {
			if(ssnfctry == null) {
				ssnfctry = new Configuration().configure().buildSessionFactory();
			}
			return ssnfctry.getCurrentSession();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}
}
