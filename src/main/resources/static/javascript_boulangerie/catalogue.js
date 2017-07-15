$(document)
		.ready(
				function() {

					var email;
					

					$.ajax({

						async : false,
						type : "GET",
						url : "/nom",
						success : function(response) {

							$('#user').append(response);
							email = response
						}
					});

					$
							.ajax({
								type : "GET",
								url : "boulangerie/ingredient",
								data : {
									email : email
								},
								success : function(response) {
									var trHTML = '';
									$
											.each(
													response,
													function(key, value) {
														trHTML += '<tr><td><input type="text" class="new col-xs-12 col-md-4" value="'
																+ value.nom
																+ '">&nbsp;<button type="button" value="'
																+ value.nom
																+ '" class=" nom btn btn-primary">modifier</button></td><td><input type="text" class="col-xs-12 col-md-2" value="'
																+ value.prix
																+ '">&nbsp;<button type="button" value="'
																+ value.nom
																+ '" id="prix"class="btn btn-primary">modifier</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" value="'
																+ value.nom
																+ '" class="btn btn-danger">Supprimer</button></td></tr>';
													})
									$('#tablingre').append(trHTML);
								}

							});

					$
							.ajax({
								type : "GET",
								url : "boulangerie/sandwichs",
								data : {
									emailboulangerie : email
								},
								success : function(response) {
									var trHTML = '';
									$
											.each(
													response,
													function(key, value) {
														trHTML += '<tr><td><input type="text" class="new col-xs-12 col-md-4" value="'
																+ value.nom
																+ '">&nbsp;<button type="button" value="'
																+ value.nom
																+ '" class=" nom btn btn-primary">modifier</button></td><td><input type="text" class="ccol-xs-12 col-md-2" value="'
																+ value.prix
																+ '">&nbsp;<button type="button" value="'
																+ value.nom
																+ '" id="prix"class="btn btn-primary">modifier</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" value="'
																+ value.nom
																+ '" class="btn btn-danger">Supprimer</button></td></tr>';
													})
									$('#tablsand').append(trHTML);
								}

							});

					$('#tablingre').on('click', '.nom', function() {

						nom = ($(this).attr("value"));
						nouveaunom= "olive noire";				
						$.ajax({
							type : "PUT",
							url : "boulangerie/ingredient/nom",
							data : {
								nom : nom,
								email : email,
								nouveaunom : nouveaunom
							},
							success : function(response) {
								
								location.reload();

							}
						})
					});
					
					$("#ajouter")
					.click(
							function() {
								
								var nom, prix;
								nom = $('#ingredient').val()
								prix = $('#prix').val();
					$.ajax({

					
						type : "POST",
						url : "boulangerie/ingredient",
						data : {
							nom : nom,
							prix : prix,
							email : email
						},
						success : function(response) {

							location.reload();
						}
					})
							})
					});
					

			
