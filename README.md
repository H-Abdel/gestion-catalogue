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

### Le schéma relationnel

+-------------+-------------+------+-----+---------+-------+
| Field       | Type        | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+-------+
| ref_prod    | varchar(25) | NO   | PRI | NULL    |       |
| designation | varchar(70) | YES  |     | NULL    |       |
| prix        | double      | YES  |     | NULL    |       |
| quantite    | int(11)     | YES  |     | NULL    |       |
+-------------+-------------+------+-----+---------+-------+

Vous pouvez nommer la base de données et la table autrement mais pensez à aporter les modifications nécessaires au ficher hibernate.cfg.xml
Pensez également à modifiez le nom d'utilisateur et le mot de passe.

## arborescence du projet

├── src
│   ├── hibernate.cfg.xml
│   ├── metier
│   │   ├── CatalogueMetierImpl.java
│   │   ├── ICatalogueMetier.java
│   │   └── Produit.java
│   └── web
│       ├── ConroleurServlet.java
│       └── ProduitModel.java
└── WebContent
    ├── css
    │   └── bootstrap.min.css
    ├── META-INF
    │   └── MANIFEST.MF
    └── WEB-INF
        ├── classes
        │   ├── hibernate.cfg.xml
        │   ├── metier
        │   │   ├── CatalogueMetierImpl.class
        │   │   ├── ICatalogueMetier.class
        │   │   └── Produit.class
        │   └── web
        │       ├── ConroleurServlet.class
        │       └── ProduitModel.class
        ├── lib
        │   ├── antlr-2.7.7.jar
        │   ├── cdi-api-1.1.jar
        │   ├── classmate-1.3.0.jar
        │   ├── dom4j-1.6.1.jar
        │   ├── el-api-2.2.jar
        │   ├── geronimo-jta_1.1_spec-1.1.1.jar
        │   ├── hibernate-commons-annotations-5.0.1.Final.jar
        │   ├── hibernate-core-5.2.4.Final.jar
        │   ├── hibernate-jpa-2.1-api-1.0.0.Final.jar
        │   ├── hibernate-jpamodelgen-5.2.4.Final.jar
        │   ├── jandex-2.0.0.Final.jar
        │   ├── javassist-3.20.0-GA.jar
        │   ├── javax.inject-1.jar
        │   ├── jboss-interceptors-api_1.1_spec-1.0.0.Beta1.jar
        │   ├── jboss-logging-3.3.0.Final.jar
        │   ├── jsr250-api-1.0.jar
        │   ├── jstl-1.2.jar
        │   └── mysql-connector-java-5.1.40-bin.jar
        └── vue_produits.jsp



