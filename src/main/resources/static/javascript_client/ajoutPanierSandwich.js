  $(document).ready(function () {
	
	var sousTotalSandwich=0;
	 var sandwichs = [];
	 var dowishs = [];

		$("#insérer").click(function() {    
	       
	        nom = $('input[type="radio"]:checked').val();
	        sessionStorage.setItem("nomPanier", nom);
	        emailboulangerie = $('select[name=selector]').val(); 
	        sessionStorage.setItem("emailboulangeriePanier", emailboulangerie);
	        $("input:radio").prop('checked', false);
	      	 });
		

		$("#ajouter").click(function() {  
	        var numero; 
	        numero =  sessionStorage.getItem("numCréa");
	        sessionStorage.setItem("numPanier", numero);
	        $("input:checkbox").prop('checked', false);
		      $('#nomd,#prixd,.ajout').empty();
			 });
		
	
});
               	 