<%@include file="header.jsp" %>
<nav class="navbar navbar-default midle-nav">
			
			<div class="collapse navbar-collapse" id="navbarmidle">
				<div class="searchtxt">
					<h1>Ajouter un vehicule</h1>
				</div>
				<c:if test = "${check == 1}">
				<div class="alert alert-success" role="alert">
  					Vehicule Ajouté avec succes
               </div>
               </c:if>
               <c:if test = "${check == 0}">
				<div class="alert alert-danger" role="alert">
  					Erreur d'ajout, verifier les données. ${erreur}
               </div>
               </c:if>
<form action="new" method="post">
  <div class="form-row">
    <div class="col-md-4 mb-3">
      <label for="immatriculation">Immatriculation</label>
      <input type="text" class="form-control" name="immatriculation" placeholder="Immatriculation"  required>
    </div>
    <div class="col-md-4 mb-3">
      <label for="modele">Modele</label>
      <input type="text" class="form-control" name="modele" placeholder="Modele"  required>
    </div>
    <div class="col-md-4 mb-3">
      <label for="kilometrage">Kilometrage</label>
        <input type="number" class="form-control" name="kilometrage" min="1" placeholder="kilometrage" required>
    </div>
  </div>
  <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="type">Type</label>
      <select  class="form-control" name="type" >
		  <option selected value="3">3</option>
		  <option value="5">5</option>
	</select>
    </div>
    <div class="col-md-3 mb-3">
      <label for="nbplace">Nombre de place</label>
      <input type="number" class="form-control" name="nbplace" placeholder="Nombre de place" min="1" max="15" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="typeCarburant">Type de carburant</label>
	  <select  class="form-control" name="typeCarburant" >
		  <option value="GPL" selected>GPL</option>
		  <option value="Electrique">Electrique</option>
		  <option value="Hydrogène">Hydrogène</option>
		  <option value="Essence" >Essence</option>
		  <option value="Diesel" >Diesel</option>
	 </select>
	  </div>
  </div>
    <div class="form-row">
    <div class="col-md-6 mb-3">
      <label for="dateA">Date achat</label>
      <input type="date" class="form-control" name="dateA" placeholder="Date achat" required>
    </div>
    <div class="col-md-6 mb-3">
      <label for="dateR">Date prochaine revision</label>
      <input type="date" class="form-control" name="dateR" placeholder="Prochaine revision" required>
    </div>
  </div>
  
  <button class="btn btn-primary" type="submit">Ajouter</button> <input class="btn btn-danger" type="reset">

</form>
</div>
</nav>
<%@include file="footer.jsp" %>