$(document).ready(function () {
 var email;

	 if((sessionStorage.getItem("nomPanier")!==null)||
				(sessionStorage.getItem("numPanier")!==null)) {
		 
		 email = (sessionStorage.getItem("emailboulangeriePanier")); 
	
	
	
       
        $.ajax({
            type: "GET", 
            url: "client/sandwichs",  
            data: {emailboulangerie:email},
            success: function(response) {    
                  	   var trHTML = '';
                  	   $.each(response, function (key, value) {   
                  		 trHTML += '<tr><td><div class="dropdown"><button class="sandwich dropdown-toggle" value="'+value.nom +'" type="button" id="dropdownMenu'+key+'" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">'+ value.nom +'</button><ul class="dropdown-menu" aria-labelledby="dropdownMenu'+key+'"></ul</div></td><td>' +value.prix + '&nbsp&nbsp&nbsp<input type="radio" value="' +value.nom + '"></td></tr>';       	  
                  	   });
         		        $('#tablsand').append(trHTML);            	   
                    
              }
	     });		 
     
	
	
	
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	$("#bouton_post").click(function() {  
		sessionStorage.clear();
        var email;
        email = $('select[name=selector]').val();
        $.ajax({
            type: "GET", 
            url: "client/sandwichs",  
            data: {emailboulangerie:email},
            success: function(response) {    
                  	   var trHTML = '';
                  	   $.each(response, function (key, value) {   
                  		 trHTML += '<tr><td><div class="dropdown"><button class="sandwich dropdown-toggle" value="'+value.nom +'" type="button" id="dropdownMenu'+key+'" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">'+ value.nom +'</button><ul class="dropdown-menu" aria-labelledby="dropdownMenu'+key+'"></ul</div></td><td>' +value.prix + '&nbsp&nbsp&nbsp<input type="radio" value="' +value.nom + '"></td></tr>';       	  
                  	   });
         		        $('#tablsand').append(trHTML);            	   
                    
              }
	     });		 
     }); 
	
	
	$('#tablsand').on('click', 'button.sandwich', function() {
		var email;
        email = $('select[name=selector]').val();
        var sandwich= ($(this).val());
        $.ajax({
            type: "GET", 
            url: "client/sandwich/ingredient",  
            data: {emailboulangerie:email,nom:sandwich},
            success: function(response) {
                  	   var trHTML = '<li class="text-center"><b>Ingrédients</b></li> <li role="separator" class="divider"></li>';
                  	   $.each(response, function (key, value) { 	 
                		 trHTML += ' <li class="text-center">'+value.nom+'</li>'});
                  	 $('.dropdown-menu').empty();
         		        $('.dropdown-menu').append(trHTML);
         		        
                  	
                                }
	     });		 
     }); 
	
});	

	