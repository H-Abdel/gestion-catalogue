package web;

import java.util.ArrayList;
import java.util.List;

import metier.Produit;

public class ProduitModel {

	private String motCle;
	private List<Produit> listeProduits = new ArrayList<Produit>();
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Produit> getListeProduits() {
		return listeProduits;
	}
	public void setListeProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	
}
