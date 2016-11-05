<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title> Catalogue Produits </title>
	<link rel="stylesheet" content="text/css" href="css/bootstrap.min.css">
</head>
<body>
	
	<div class="container">

	<nav class="navbar navbar-inverse">
	  	<form class="navbar-form navbar-left" role="search"
			  action="ConroleurServlet" method="post">
		  <div class="form-group">
		    <input type="text" class="form-control" placeholder="mot clé" name="motCle">
		  </div>
		  <button type="submit" class="btn btn-default" value="chercher" name="action">Chercher</button>
		</form>
	</nav>
	<br />
	
	<div class="row">
	<div class="col-sm-6">
	  	
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Référence</th><th>Désignation</th><th>Prix</th><th>Quantité</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${pm.listeProduits}" var="p">
				<tr>
					<td>${p.reference}</td><td>${p.designation}</td><td>${p.prix}</td><td>${p.quantite}</td>
					<td><a href="ConroleurServlet?action=supprimer&ref=${ p.reference }"> Supprimer </a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		
		
		</div>
	  <div class="col-sm-6">
	
		<form class="form-horizontal" method="post">
		  <fieldset>
		  <legend>Ajouter un nouveau produit</legend>
		  <div class="form-group">
		    <label class="control-label col-sm-2">Référence:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="ref" placeholder="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2">Désignation:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="des" placeholder="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2">Prix:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="prix" placeholder="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-2">Quantité:</label>
		    <div class="col-sm-10">
		      <input type="text" class="form-control" name="quant" placeholder="">
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary" value="enregistrer" name="action">Enregistrer</button>
		    </div>
		  </div>
		  </fieldset>
		</form>
		
	  </div>
	  
	  
	  
	</div>
	</div>

</body>
</html>