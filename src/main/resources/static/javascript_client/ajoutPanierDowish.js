$(document).ready(function () {
		 
    	$('#dowish').click(function() {
            // validate and process form here
             var radio_button_value,nom
              radio_button_value = $('select[name=selector]').val(); 
             var ingredients = [];
             nom= $("#nom").val();
             console.log(radio_button_value);
             sessionStorage.removeItem("numCréa");
             $(':checkbox:checked').each(function(i){
                 ingredients[i] = $(this).val();
               });    
            $.ajax({
                type: "POST", 
                url: "client/dowish",  
                data: {emailboulangerie:radio_button_value, nom:nom, ingredient:ingredients.join(',')},
                success: function(response) {   
                	
                	sessionStorage.setItem("numCréa",(response.numerodowish.codebarre));
                	 var trHTML = '';
                	 trHTML = response.nom;
                  	 $('#nomd').append(trHTML); 
                      	 
                  	 var trHTML = '';
                  	 trHTML = response.prix; 
                  	 $('#prixd').append(trHTML); 
                  	 
                  	var trHTML = '';
                       $.each(response.ingredients, function (key, value) {
                        		 trHTML += '<dd class="ajout">'+value.nom+'</dd>';
                        		 
                       })
                      $('#nom').val('')
                       $('.dl-horizontal').append(trHTML);
                      
                }
    	     });		 
         }); 
    });
    
 
    
    
    
    