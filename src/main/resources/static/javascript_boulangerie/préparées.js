$(document).ready(function () {
	 var email, statut;
	
	 statut='préparée';
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
           url: "boulangerie/commandes",  
           data: {email:email, statut:statut},
           success: function(response) {  
        	   
        	   var trHTML = '';
                 	   $.each(response, function (clé, valeur) {   //commande
                 		 
               		 trHTML +='<div class="dropdown"><button id="'+clé+'" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class=" commande btn btn-default" value="'+valeur.panier.numeropanier.référence+'"><b>numéro de commande:&nbsp</b>'+valeur.numero.numero+'</button><ul class="dropdown-menu" aria-labelledby="'+clé+'"></ul></div><p><b>email client:&nbsp</b>'+valeur.panier.client.email+'&nbsp<b>tel:&nbsp</b>'+valeur.panier.client.tel+'</p><p><b>nom:&nbsp</b>'+valeur.panier.client.nom+'&nbsp<b>prénom:&nbsp</b>'+valeur.panier.client.prenom+'</p><p><b>effectuer le :</b>'+valeur.date+'</p><p><b>statut:&nbsp</b>'+valeur.statut.nom+'</p><p><b>commentaire:&nbsp</b>'+valeur.commentaire+'</p>  <p><b>Total:&nbsp</b>'+valeur.panier.total+'eu</p> <p><b>Date de retrait:&nbsp</b>'+valeur.panier.dateretrait+'</p><p> <b>Heure de retrait:&nbsp</b>'+valeur.panier.heureretrait+'</p><a id="valider"class="btn btn-primary" value="'+valeur.numero.numero+'" role="button">Solder</a><hr /></div> ' 
        		                       	    		 
           				 			  })

               		 $('#réponse').append(trHTML);
                   	      
             }
	     })	 
	     
	   
    }); 
  

	   $('#réponse').on('click', '.commande', function() {
	      var trHTML = '';
		 var numero;
		 numero =($(this).attr("value"));
	        $.ajax({
	            type: "GET", 
	            url: "client/panier",  
	            data: {référence:numero},
	            success: function(response) {  
	            	
	            	
	            	
	                  	 $.each(response.dowishs, function (clé, valeur) {   
	                  		 
	                  		 trHTML += '<b>dowish: </b>'+valeur.nom+'</br><b>ingrédients:</b></br>';
	                  		 $.each(this.ingredients, function(c, v) {
	           				  trHTML += '&nbsp'+v.nom+'&nbsp</br>'; 
	           			  });
	                  		trHTML +='<hr>'
	                  });	
	                  	$.each(response.sandwichs, function (clé, valeur) {   
	                  		 trHTML += '<b>sandwich: </b>'+valeur.nom+'</br><b>ingrédients:</b></br>'
	                  		 $.each(this.ingredients, function(c, v) {
	              				  trHTML += '&nbsp'+v.nom+'</br>'; 
	              			  });
	                  		
	                  	   });
	                  
	                  	 $('.dropdown-menu').empty();
	         		        $('.dropdown-menu').append(trHTML);
         		        
}
	
	        });
	 });  
	   
	   $('#réponse').on('click', '#valider', function() {
		      var trHTML = '';
			 var numero;
			 numero =($(this).attr("value"));
		        $.ajax({
		            type: "PUT", 
		            url: "boulangerie/commande/soldée",  
		            data: {numero:numero},
		            success: function(response) {  
		            	alert("Commande n°: " + numero+" validée");
		            	location.reload();

		            	
		           }
		            })
	   });

