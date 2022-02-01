 <%@include file="header.jsp" %>

		<nav class="navbar navbar-default midle-nav">
			<div class="collapse navbar-collapse" id="navbarmidle">
				<div class="searchtxt">
					<h1>Listes des Vehicules</h1>
				</div>
			</div>
		</nav>
		 <c:if test="${!empty erreur}">
		    <div class="alert alert-danger" role="alert">
		  	Erreur de suppression!!!. ${erreur}
		    </div>
		</c:if>
		<br>
		<div class="table-responsive">
			    <table border ="1" width="500" align="center" class="table table-bordered table-dark">
			         <tr bgcolor="00997F">
			          <th scope="col"><b>Immatriculation</b></th>
			          <th scope="col"><b>Modele</b></th>
			          <th scope="col"><b>Kilometrage</b></th>
			          <th scope="col"><b>Type</b></th>
			          <th scope="col"><b>Nombre places</b></th>
			          <th scope="col"><b>Type Carburant</b></th>
			          <th scope="col"><b>Date Achat</b></th>
			          <th scope="col"><b>Date prochain revision </b></th>
			          <th scope="col"><b>Action</b></th>
			         </tr>
				      <c:forEach var="vehi" items="${vehicules}">
				       <tr>
						<td>${vehi.immatriculation }</td>
						<td>${vehi.modele }</td>
						<td>${vehi.kilometrage }</td>
						<td>${vehi.type}</td>
						<td>${vehi.nbPlace}</td>
						<td>${vehi.typeCarburant }</td>
						<td>${vehi.dateAchat}</td>
						<td>${vehi.dateProchaineRevision}</td>
						<td>
						<button class="btn btn-info" onclick="window.location.href='afficher?inf=${vehi.immatriculation }'"><i class="fa fa-eye" aria-hidden="true"></i></button>
						<button class="btn btn-primary" onclick="window.location.href='modifier?mod=${vehi.immatriculation }'"><i class="fa fa-pencil-square-o"></i></button>
						<button class="btn btn-danger" onclick="window.location.href='Acceuil?supp=${vehi.immatriculation }'"><i class="fa fa-trash-o"></i></button>
						</td>
					  </tr>
				       </c:forEach>
               </table> 
      		   </div>
	<br>	<br>	<br> 	<br>
		<br>
<%@include file="footer.jsp" %>
	