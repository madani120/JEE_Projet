<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Station</title>
</head>
<body>
<h1>Bienvenu dans notre webservice de consultation de prix de carburants</h1>
 <i>Vous aurez forcement besoin d'une extension comme Postman pour tester le service de suppression ou de modification </i>:
 <hr>
<p>*Pour consulter les prix de carburant en fonction d'une ville veuiller saisir l'URL : <b>http://localhost:8080/projetWeb/rest/station/ville/cp</b> </p>
<p>Avec <b>cp</b>: le code postal de la ville souhaiter </p>

<p>*Pour consulter les prix de carburant en fonction d'un departement veuiller saisir l'URL : <b>http://localhost:8080/projetWeb/rest/station/dep/num</b> </p>
<p>Avec <b>num</b>: le numero du departement souhaiter </p>


<p>*Pour Supprimer un carburant <b>http://localhost:8080/projetWeb/rest/station/carburant/idPDV/nom</b> </p>
<p>Avec <b>idPDV</b>: l'identifiant du point de vente  et <b>nom</b> le nom du carburant a supprimer,  assurer vous de changer HTTP methods en <b>DELETE</b></p>

<p>*Pour modifier un carburant <b>http://localhost:8080/projetWeb/rest/station/carburant/</b> </p>
<p>Avec <b>id</b>: l'identifiant du carburant a supprimer </p>
<p>Et indiquer dans le corps de la requette en XML les champs à modifier et assurer vous de changer HTTP methods en <b>PUT</b></p>




</body>
</html>