<%@include file="header.jsp" %>
<nav class="navbar navbar-default midle-nav">
			
			<div class="collapse navbar-collapse" id="navbarmidle">
				<div class="searchtxt">
					<h1>Info vehicule</h1>
				</div>
				<c:if test = "${check == 1}">
				<div class="alert alert-success" role="alert">
  					Approvisionnement rajouté
               </div>
               </c:if>
               <c:if test = "${check == 0}">
				<div class="alert alert-danger" role="alert">
  					Erreur d'ajout, verifier les données d'approvisionnnement. ${erreur}
               </div>
               </c:if>
</div>
</nav>
<div class="list-group">
  <button type="button" class="list-group-item list-group-item-action active">
   <b>Immatriculation:  </b> ${vehi.immatriculation}
  </button>
  <button type="button" class="list-group-item list-group-item-action"><b>Modele :</b> ${vehi.modele} </button>
  <button type="button" class="list-group-item list-group-item-action"><b>Killometrage:</b> ${vehi.kilometrage} Km</button>
  <button type="button" class="list-group-item list-group-item-action"><b>Type :</b> ${vehi.type } Portes</button>
  <button type="button" class="list-group-item list-group-item-action" ><b>Nombre de place:</b> ${vehi.nbPlace}</button>
  <button type="button" class="list-group-item list-group-item-action" ><b>Type de carburant:</b> ${vehi.typeCarburant}</button>
  <button type="button" class="list-group-item list-group-item-action" ><b>Date achat:</b> ${vehi.dateAchat}</button>
  <button type="button" class="list-group-item list-group-item-action" ><b>Date Prochaine revision:</b> ${vehi.dateProchaineRevision}</button>
  <button type="button" class="list-group-item list-group-item-action" >
  <b>Mes approvisionnements:</b>  <br>
  <table border ="1" width="500" align="center" class="table table-bordered table-dark">
			         <tr bgcolor="00997F">
			          <th scope="col"><b>Id</b></th>
			          <th scope="col"><b>Date</b></th>
			          <th scope="col"><b>Quantite</b></th>
			          <th scope="col"><b>PU</b></th>
			          <th scope="col"><b>Montant</b></th>
			          <th scope="col"><b>Action</b></th>
			         </tr>
				      <c:forEach var="ap" items="${vehi.aps}">
				       <tr>
						<td>${ap.id}</td>
						<td>${ap.dateapprov}</td>
						<td>${ap.quantite }</td>
						<td>${ap.prixUnitaire}</td>
						<td>${ap.montant}</td>
						<td>
						<button class="btn btn-danger" onclick="window.location.href='afficher?supp=${ap.id}'"><i class="fa fa-trash-o"></i></button>
						</td>
					  </tr>
				       </c:forEach>
               </table> 
  </button>
  <form class="form-inline" action="afficher" method="post">
		  <div class="form-group mb-2">
		    <label for="Im" class="sr-only">Immatriculation</label>
		    <input type="text" readonly class="form-control" name="Im" value="${vehi.immatriculation }" required>
		  </div>
		  <div class="form-group mx-sm-3 mb-2">
		    <label for="dateap" class="sr-only">Date </label>
		    <input type="date" class="form-control" name="dateap" placeholder="date Approvisionnemment" required>
		  </div>
		   <div class="form-group mx-sm-3 mb-2">
		    <label for="qte" class="sr-only">Quantite </label>
		    <input type="number" class="form-control" name="qte" min="1" placeholder="quantite" required>
		  </div>
		   <div class="form-group mx-sm-3 mb-2">
		    <label for="pu" class="sr-only">Prix unitaire </label>
		    <input type="number" class="form-control" name="pu" min="1" placeholder="prix unitaire en euro" required>
		  </div>
		   <div class="form-group mx-sm-3 mb-2">
		  <button type="submit" class="btn btn-primary mb-2">Ajouter Approvisionnement</button>
     </form>
</div>
<br>	<br>	<br> 	<br>
		<br>
<%@include file="footer.jsp" %>