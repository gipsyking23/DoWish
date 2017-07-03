	
$(document).ready(function () {

	
		
		 var emailclient, emailboulangerie; 
			$.ajax({
				
			    async:false, 
				type : "GET",
				url : "/nom",
				success : function(response) {
					emailclient=response; 
					 $('#user').append(response);
		      
				}
				})	
				
	$("#valider").click(function() {
		var dateretrait, heureretrait, sandwichs, codedowishs; 
		dateretrait= $("#date").val();
		heureretrait=$("#heure").val()+':00';
		 
		emailboulangerie=(sessionStorage.getItem("emailboulangeriePanier"));
		
		var sandwichs = [];
		sandwichs = JSON.parse(sessionStorage.getItem("sandwichs"));
        console.log(sandwichs);
        
        var dowishs = [];
        dowishs = JSON.parse(sessionStorage.getItem("dowishs"));
        console.log(dowishs);
    	
        
        $.ajax({
            type: "POST", 
            url: "client/panier",  
            data: {dateretrait:dateretrait, heureretrait:heureretrait, emailclient:emailclient, sandwich:sandwichs.join(','), codedowish:dowishs.join(','), emailboulangerie:emailboulangerie},
            success: function(response) { 
            	
            	 if (confirm(response)){
            		 
            		 var ref ='';
            		 ref= response.numeropanier.référence;
            		 sessionStorage.setItem("ref",ref);
            		 console.log(ref);
            		 var trHTML = '';
            		 trHTML +='<div class="row"><div class="thumbnail"><img src="..." alt="..."><div class="caption"><h3>RECAPITULATIF</h3><p><b>date de retrait:</b>'+response.dateretrait+'</p><p><b>heure de retrait:</b>'+response.heureretrait+'</p>' 
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
        		 trHTML +='<p><b>total:</b>'+response.total+'eu</p><div id="footer"><textarea class="form-control text-center" placeholder="Ajouter un commentaire à votre réservation" rows="2"></textarea><p><a id="modifier" class="btn btn-primary" role="button">Modifier</a> <a id="envoyer"class="btn btn-default" role="button">Envoyer</a></p></div></div></div></div></div>'
            		 $('#recap').html(trHTML);
            		 
            		 
            		 
            		 
            		 
            	 };
             }
        });
       
            		 
	});
	
	$('#recap').on('click', '#envoyer', function() {
		var commentaire, référence;
		commentaire= $("textarea").val();
		
		référence= sessionStorage.getItem("ref");
		console.log(commentaire);
        console.log(emailboulangerie);
        console.log(référence);
		
       console.log("chico");
        $.ajax({
            type: "POST", 
            url: "client/commande",  
            data: {commentaire:commentaire, email:emailboulangerie, référence:référence},
            

            
            success: function(response) { 
            	
            	 if (confirm){
            		
            		 var trHTML = '';
            		 trHTML +='<p><b>numéro de commande:</b>'+response.numero.numero+'</p><p><b>effectuer le :</b>'+response.date+'</p><p><b>statut:</b>'+response.statut.nom+'</p><p><b>commentaire:</b>'+response.commentaire+'</p>  <p><a href="commandes.html" class="btn btn-primary" role="button">Voir mes commandes</a></p>' 
            		 $('#footer').html(trHTML);
            		 $('.page-header').html('<h1>VOTRE RESERVATION</h1>')
            		 sessionStorage.clear();
            	 };
             }
        });
            		 
	});




});