# Gestion de catalogue

Ce projet consiste à réaliser une application Java EE qui permet de gérer un catalogue de produits.
Cette application a pour but principal la mise en pratique des technologies suivantes :

	* Bootstrap
	* Hibernate
	* Spring MVC
	* Spring IoC

## Fonctionnalités

L'utilisateur de l'application doit pouvoir :

	- Ajouter un produit à la base de données via un formulaire
	- Chercher un produit par mot clé 
	- Supprimer un produit
	- Editer un produit

Les fonctionnalités ajout et recherche de produits fonctionnent correctrement.
Les autres fonctionnalités n'ont pas encore abouties.

## Requis

	* Apache Tomcat 8
	* JRE 8
	* SGBD mySQL

Le SGBD utilisé pour ce projet est mySQL. Si vous voulez essayer l'application avec un autre SGBD, pensez à modifier le fichier hibernate.cfg.xml en présisant le JDBC correspondant au SGBD de vôtre choix et n'oublier pas de rajouter son driver au Build Path (dans le dossier lib). 

Voud devez au préalable créer une base de données ayant pour nom 'cat_prod' et y rajouter une table
nommée produits. 

### Commande SQL
```
CREATE DATABASE cat_prod

USE cat_prod

CREATE TABLE produits ( 
	ref_prod    varchar(25) not null, 
	designation varchar(70) default null, 
	prix        double 	default null, 
	quantite    int(11) 	default null, 
	primary key (ref_prod)
);
```

Vous pouvez nommer la base de données et la table autrement mais pensez à aporter les modifications nécessaires au fichier hibernate.cfg.xml.
Pensez également à modifiez le nom d'utilisateur et le mot de passe.





