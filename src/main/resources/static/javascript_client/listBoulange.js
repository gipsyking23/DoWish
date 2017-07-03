$(document).ready(
		function() {
var email; 
			 $.ajax({
					
				    async:false, 
					type : "GET",
					url : "/nom",
					success : function(response) {
						
						 $('#user').append(response);
		          
					}
					})
					
					if((sessionStorage.getItem("nomPanier")!==null)||(sessionStorage.getItem("numPanier")!==null)) {
						email = (sessionStorage.getItem("emailboulangeriePanier")); 
					
						$.ajax({

							type : "GET",
							url : "client/boulangerie",
							 data: {email:email},
							error : function(xhr, status, error) {
								var err = eval("(" + xhr.responseText + ")");
								alert(err.Message);
							},
							success : function(response) {
									var trHTML = '';
								
										trHTML += '<option value="' + response.email + '">'
												+ response.nom + '</option>';
									
									$('.form-control').html(trHTML);
								
							}
						});	
					}
					
					
					else{
					
			$.ajax({

				type : "GET",
				url : "client/boulangeries",
				error : function(xhr, status, error) {
					var err = eval("(" + xhr.responseText + ")");
					alert(err.Message);
				},
				success : function(response) {
						var trHTML = '';
						$.each(response, function(key, value) {
							trHTML += '<option value="' + value.email + '">'
									+ value.nom + '</option>';
						});
						$('.form-control').append(trHTML);
					
				}
			});
			 }
		})
