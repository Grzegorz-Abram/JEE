/*******************************************************************************
 * Copyright (c) 1998, 2012 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:     
 *     10/02/2008-1.1M1 Michael O'Brien 
 *       - 250473: This DDL application managed DDL generation application is required before running the  
 *       tutorial submissions for WebLogic, JBoss, OC4J, GlassFish, Tomcat and WebSphere 
 *       - this project is specific to the Oracle database - customization via persistence.xml is possible for other databases.
 *       see
 *       http://wiki.eclipse.org/EclipseLink/Examples/JPA#JPA_Web_Application_Tutorials
 ******************************************************************************/

package main;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Item;

/**
 * Purpose: Automatic DDL generation script This test class assumes that we are
 * working with a single Item entity data model. This class is used to invoke
 * automatic DDL generation on the database specified by the persistence unit.
 * The DDL generation occurs on an application managed EM on a non-JTA
 * datasource
 * 
 * The consumer of the DDL generated schema are all the Web/EJB container
 * example applications in the org.eclipse.persistence.jpa.server namespace.
 * 
 */
public class Test {

	// Application managed EMF and EM
	public EntityManagerFactory emf = null;
	public EntityManager entityManager = null;
	// Reference the database specific persistence unit in persistence.xml
	public static final String PU_NAME_CREATE = "GlassfishTest";

	/**
	 * Create the EMF and EM and start a transaction (out of container context)
	 * 
	 * @param puName
	 */
	private void initialize(String puName) {
		try {
			// Initialize an application managed JPA emf and em via META-INF
			emf = Persistence.createEntityManagerFactory(puName);
			entityManager = emf.createEntityManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Close the application managed EM and EMF
	 */
	public void finalize() {
		// close JPA
		try {
			if (null != getEntityManager()) {
				getEntityManager().close();
				getEmf().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insert some test data on the database Assume that the entity manager is
	 * set to drop/create tables - or they exist
	 */
	private void processInsert() {
		// Insert schema and classes into the database

		// create 2 items and link them
		Item item1 = new Item();
		Item item2 = new Item();
		try {
			// Cache objects
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(item1);
			System.out.println("_createDatabase() Inserted: " + item1);
			getEntityManager().persist(item2);
			System.out.println("_createDatabase() Inserted: " + item2);
			// Store objects
			getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generateGlider(null);
	}

	/**
	 * Attempt to create a "Complete Graph" of entities of numEntities size
	 * where each Item has a @ManyToMany relationship to all other Item
	 * entities.
	 * 
	 * @param numEntities
	 */
	private void persistCompleteGraphOfEntities(int numEntities) {
		// Insert schema and classes into the database by using an EM with DDL
		// generation
		// create n items of entities
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < numEntities; i++) {
			Item item = new Item();
			items.add(item);
		}

		try {
			// Cache objects
			EntityManager em = getEntityManager();
			if (null == em) {
				System.out
						.println("EntityManager is null: Check your persistence.xml properties");
			} else {
				EntityTransaction transaction = em.getTransaction();
				if (null == transaction) {
					System.out
							.println("Cannot get a transaction from entityManager: "
									+ em);
				} else {
					transaction.begin();
					// all items must be persisted together in a single
					// transaction
					for (int current = 0; current < numEntities; current++) {
						getEntityManager().persist(items.get(current));
						System.out
								.println("_persistCompleteGraphOfEntities() Inserted: "
										+ items.get(current));
					}
					// Store objects
					transaction.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// generateGlider(null);
	}

	/**
	 * Generate a W. H. Gosper Glider gun glider self-replicating pattern
	 * 
	 * @param out
	 */
	private void generateGlider(PrintWriter out) {
		// Insert schema and classes into the database
		// Create glider
		// . 5 .
		// . . 4
		// 1 2 3
		// Create the items
		int numItems = 5;
		List<Item> items = new ArrayList<Item>();
		for (int i = 0; i < numItems; i++) {
			Item item = new Item();
			items.add(item);
		}

		Item item1 = items.get(0);
		Item item2 = items.get(1);
		Item item3 = items.get(2);
		Item item4 = items.get(3);
		Item item5 = items.get(4);

		// store first before creating relationships
		try {
			// Cache objects
			EntityManager em = getEntityManager();
			if (null == em) {
				System.out
						.println("EntityManager is null: Check your persistence.xml properties");
			} else {
				EntityTransaction transaction = em.getTransaction();
				if (null == transaction) {
					System.out
							.println("Cannot get a transaction from entityManager: "
									+ em);
				} else {
					transaction.begin();
					// all items must be persisted together in a single
					// transaction
					for (int current = 0; current < numItems; current++) {
						em.persist(items.get(current));
						System.out
								.println("_persistCompleteGraphOfEntities() Inserted: "
										+ items.get(current));
					}
					// Store objects
					transaction.commit();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get test data from the database
	 * 
	 * @param singleResult
	 * @param jpqlQuery
	 * @return always returns a list for a single/multiple result
	 */
	public List<Item> query(boolean singleResult, String jpqlQuery) {
		Query aQuery = null;
		Item aResult = null;
		// send back an empty list if we have EM problems
		List<Item> aResultsList = new ArrayList<Item>();
		try {
			EntityManager em = getEntityManager();
			if (null == em) {
				System.out
						.println("EntityManager is null: Check your persistence.xml properties");
			} else {
				aQuery = em.createQuery(jpqlQuery);
				if (singleResult) {
					aResult = (Item) aQuery.getSingleResult();
					aResultsList = new ArrayList<Item>();
					if (null != aResult) {
						aResultsList.add(aResult);
					}
				} else {
					// Handle no results - create an empty list
					aResultsList = aQuery.getResultList();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aResultsList;
	}

	private void queryTest() {
		List<Item> rowsList = (List<Item>) query(false,
				"select object(e) from Item e");
		Iterator<Item> anIterator = rowsList.iterator();
		System.out.println(rowsList.size() + " Entities in storage");
		int rows = 0;
		while (anIterator.hasNext()) {
			Object anObject = anIterator.next();
			rows++;
			// Use an extended DTO wrapper around one of the entities
			System.out.println("Item: " + (Item)anObject);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// //doCreateTables();
		doQuery();
		// testMethod();
	}

	/**
	 * doQuery() will invoke DDL generation via it's PU properties
	 */
	public static void doQuery() {
		Test aClient = new Test();
		aClient.initialize(PU_NAME_CREATE);
		// aClient.processInsert();
		// aClient.persistCompleteGraphOfEntities(2); // variable SOE down to
		// 875
		aClient.generateGlider(null);
		aClient.queryTest();
		aClient.finalize();
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntifyManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}