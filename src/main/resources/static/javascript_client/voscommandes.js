$(document).ready(function () {
	 var email;
	 
	 $.ajax({
			
		    async:false, 
			type : "GET",
			url : "/nom",
			success : function(response) {
				
				 $('#user').append(response);
             email= response
			}
		});
        $.ajax({
            type: "GET", 
            url: "client/commandes",  
            data: {email:email},
            success: function(response) {    
                  	   $.each(response, function (clé, valeur) {   
                  		 var trHTML = '';
                		 trHTML +='<p><b>numéro de commande: </b>'+valeur.numero.numero+'</p><p><b>effectuer le : </b>'+valeur.date+'</p><p><b>boulangerie: </b>'+valeur.boulangerie.nom+'</p><p><b>statut: </b>'+valeur.statut.nom+'</p><p><b>commentaire: </b>'+valeur.commentaire+'</p><a class="btn btn-primary" value="'+valeur.panier.numeropanier.référence+'" role="button" data-toggle="collapse" href="#collapseExample'+clé+'"aria-expanded="false" aria-controls="collapseExample">détail</a>  <p></p><div class="collapse" id="collapseExample'+clé+'"><div class="well"><b>Total:</b>'+valeur.panier.total+'eu <b>Date de retrait:</b>'+valeur.panier.dateretrait+' <b>Heure de retrait:</b>'+valeur.panier.heureretrait+'<div class="wellwell"></div></div></div><hr /> ' 
         		          $('#réponse').append(trHTML);
                		 
                		 
                    
              })
	     }	 
     }); 

	 $('#réponse').on('click', '.btn', function() {
		 var trHTML = '';
		 var numero;
		 numero =($(this).attr("value"));
	        $.ajax({
	            type: "GET", 
	            url: "client/panier",  
	            data: {référence:numero},
	            success: function(response) {  
	            	
	            	trHTML += '<b>date de retrait:</b>'+response.dateretrait+'&nbsp<b>heure de retrait:</b>'+response.heureretrait+'</br>';
	            	
	                  	 $.each(response.dowishs, function (clé, valeur) {   
	                  		 trHTML += '<b>dowish:</b>'+valeur.nom+'&nbsp<b>ingrédients:</b>';
	                  		 $.each(this.ingredients, function(c, v) {
	           				  trHTML += ',&nbsp'+v.nom+'&nbsp'; 
	           			  });
	                  		trHTML += '&nbsp <b>prix:</b>'+valeur.prix+'</br>'
	                  });	
	                  	$.each(response.sandwichs, function (clé, valeur) {   
	                  		 trHTML += '<b>sandwich:</b>'+valeur.nom+'&nbsp<b>ingrédients:</b>'
	                  		 $.each(this.ingredients, function(c, v) {
	              				  trHTML += ',&nbsp'+v.nom+'&nbsp'; 
	              			  });
	                  		trHTML += '&nbsp <b>prix:</b>'+valeur.prix+'</br>'
	                  	   });
	                  
	                  	$('.well').html(trHTML);
}
	
	        });
	 });
});