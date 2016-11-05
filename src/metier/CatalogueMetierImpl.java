package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CatalogueMetierImpl implements ICatalogueMetier {

	@Override
	public void addProduit(Produit p) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Produit.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		
		try {
			Produit tempProduit = new Produit(p.getReference(), p.getDesignation(), p.getPrix(), p.getQuantite());
			session.beginTransaction();
			session.save(tempProduit);
			session.getTransaction().commit();
		
		} finally {
			factory.close();
		}
		
	}

	@Override
	public List<Produit> listProduits() {
		
		SessionFactory factory = new Configuration().configure()
													.addAnnotatedClass(Produit.class)
													.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		List<Produit> tousProduits;
		
		try {
			session.beginTransaction();
			tousProduits = (List<Produit>) (List<Produit>) session.createQuery("from Produit").list();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return tousProduits;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Produit.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		List<Produit> produits;
		
		try {
			session.beginTransaction();
			produits = session.createQuery("FROM Produit p WHERE p.designation LIKE '%"+mc+"%'").list();
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return produits;
	}

	@Override
	public Produit getProduit(String ref) {
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Produit.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		Produit produit = null;
		
		try {
			session.beginTransaction();
			produit = (Produit) session.createQuery("FROM Produit p WHERE p.ref_prod = '"+ref+"'");
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
		return produit;
		
	}

	@Override
	public void updateProduit(Produit p) {
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Produit.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			//
			Produit produit = session.get(Produit.class, p.getReference());
			produit.setDesignation(p.getDesignation());
			produit.setPrix(p.getPrix());
			produit.setQuantite(p.getQuantite());
			//
			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

	@Override
	public void deleteProduit(String ref) {
		
		SessionFactory factory = new Configuration().configure()
				.addAnnotatedClass(Produit.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			Produit produit = session.get(Produit.class, ref);
			session.delete(produit);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		
	}

}

