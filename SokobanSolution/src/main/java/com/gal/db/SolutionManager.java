package com.gal.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class SolutionManager {
	private static SessionFactory factory;

	public SolutionManager() {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}

	public void addSolution(SokobanSolution solution) {
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();

		Session session = factory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(solution);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			System.out.println(ex.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
	}

	public String getSolution(String solutionId) {
		Session session = null;

		try {
			session = factory.openSession();

			SokobanSolution sol = session.get(SokobanSolution.class, solutionId);

			if (sol != null) {
				return sol.getSolution();
			}
		} catch (HibernateException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (session != null)
				session.close();
		}
		return "block";
	}

	public boolean isSolutionExist(String solutionId) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("FROM SokobanSolution E WHERE solutionId = "+solutionId );
		if (query.list() == null)
			return false;
		else if (query.list().size() == 0)
			return false;
		else
			return true;
	}

}
