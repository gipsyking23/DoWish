$(document).ready(function () {
	var email; 
	$.ajax({
		
	    async:false, 
		type : "GET",
		url : "/nom",
		success : function(response) {
			email=response; 
			 $('#user').append(response);
      
		}
		})
	
	
	
	
	
	
	 
	 
        $.ajax({
            type: "GET", 
            url: "client",  
            data: {email:email},
            success: function(response) {    
                  		 var trHTML = '';
                		 trHTML +='<p><b>NOM: </b>'+response.nom+'</p><p><b>Prénom: </b>'+response.prenom+'</p><p><b>Email: </b>'+response.email+'<a class="btn btn-primary" data-toggle="modal"data-target="#myModalemail" role="button">modifier</a></p><p><b>Téléphone: </b>'+response.tel+'<a class="btn btn-primary" data-toggle="modal"data-target="#myModaltel" role="button">modifier</a></p><hr />  <div class="modal fade" id="myModalemail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><h4 id="myModalLabel">Modifiez votre email</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group"><label for="email" class="col-sm-2 control-label">Nouveau mail:</label><div class="col-sm-6"><input type="email" class="form-control" id="email" placeholder="ex: Jacky34 "></div></div></form></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">fermer</button><button type="submit" value="submit" id="boutonemail" class="btn btn-primary">ENREGISTER</button></div></div></div></div><div class="modal fade" id="myModaltel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"><div class="modal-dialog" role="document"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button><h4 id="myModalLabel">Modifiez votre téléphone</h4></div><div class="modal-body"><form class="form-horizontal"><div class="form-group"><label for="tel" class="col-sm-2 control-label">Nouveau tel:</label><div class="col-sm-6"><input type="tel" class="form-control" id="tel" placeholder="ex: 061664578 "></div></div></form></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">fermer</button><button type="submit" value="submit" id="boutontel" class="btn btn-primary">ENREGISTER</button></div></div></div></div>'            		 
                		 $('#réponse').append(trHTML);
                		 
                		 
                		 
          	          
	     }	 
        });

	  $('#réponse').on('click', '#boutonemail', function() {
		 var ancien;
		 ancien= email; 
		 nouveau = $('#email').val();
		 
	        $.ajax({
	            type: "PUT", 
	            url: "client/email",  
	            data: {email:ancien, nouveauemail:nouveau},
	            success: function(response) {    
	                  	  
	            	var trHTML = '';
	            	trHTML +='<p><b>NOM: </b>'+response.nom+'</p><p><b>Prénom: </b>'+response.prenom+'</p><p><b>Email: </b>'+response.email+'</p><p><b>Téléphone: </b>'+response.tel+'</p>'
	            	$('#réponse').html(trHTML);
	            	 $('#myModalemail').modal('hide');
	            	 $('.modal-backdrop').hide();
	            	 window.location.href="http://localhost:8080/logout; 

	            }
	
	        });
	  });
	  
	  
	  $('#réponse').on('click', '#boutontel', function() {
			 var tel;
			
			 tel = $('#tel').val();
			 
		        $.ajax({
		            type: "PUT", 
		            url: "client/tel",  
		            data: {email:email, nouveautel:tel},
		            success: function(response) {    
		                  	  
		            	var trHTML = '';
		            	trHTML +='<p><b>NOM: </b>'+response.nom+'</p><p><b>Prénom: </b>'+response.prenom+'</p><p><b>Email: </b>'+response.email+'</p><p><b>Téléphone: </b>'+response.tel+'</p>'
		            	$('#réponse').html(trHTML);
		            	 $('#myModaltel').modal('hide');
		            	 $('.modal-backdrop').hide();

		            }
		
		        });
		  });
	  
	  
});
	