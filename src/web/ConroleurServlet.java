package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CatalogueMetierImpl;
import metier.ICatalogueMetier;
import metier.Produit;

@WebServlet("/ConroleurServlet")
public class ConroleurServlet extends HttpServlet {
	
	private ICatalogueMetier metier;
	private ProduitModel pm;
	
	@Override
	public void init() throws ServletException {
		metier = new CatalogueMetierImpl();
		pm = new ProduitModel();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		pm.setListeProduits(metier.listProduits());
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/WEB-INF/vue_produits.jsp")
		   .forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		if (action != null) {
			if (action.equals("chercher")) {
				pm.setMotCle(request.getParameter("motCle"));
				List<Produit> listeProduits = metier.produitsParMC(pm.getMotCle());
				pm.setListeProduits(listeProduits);
			}
			else if (action.equals("supprimer")) {
				metier.deleteProduit(request.getParameter("ref"));
				pm.setListeProduits(metier.listProduits());
			}
			else if (action.equals("enregistrer")) {
				Produit p = new Produit();
				p.setReference(request.getParameter("ref"));
				p.setDesignation(request.getParameter("des"));
				p.setQuantite(Integer.parseInt(request.getParameter("quant")));
				p.setPrix(Double.parseDouble(request.getParameter("prix")));
				metier.addProduit(p);
				pm.setListeProduits(metier.listProduits());
			}
			else {
				pm.setListeProduits(metier.listProduits());
			}
		
		}
		//
		
		
		//***************************************************************
		request.setAttribute("pm", pm);
		request.getRequestDispatcher("/WEB-INF/vue_produits.jsp")
			   .forward(request, response);
		//***************************************************************
	}

}
