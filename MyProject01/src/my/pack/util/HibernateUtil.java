package my.pack.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	private static SessionFactory configureSessionFactory()
			throws HibernateException {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.h2.cfg.xml");
		// configuration.configure("hibernate.hsqldb.cfg.xml");
		serviceRegistry = new ServiceRegistryBuilder().applySettings(
				configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return configureSessionFactory();
	}

}
