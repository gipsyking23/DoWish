$(document).ready(
		function() {

			var email, statut;
			
			statut = 'validée';
			
			

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
				type : "GET",
				url : "boulangerie/commande/enattente",
				data : {
					email : email
				},
				success : function(response) {

					var trHTML = response;
					
					$('.valider').html(trHTML);
				}
			});

			$.ajax({
				type : "GET",
				url : "boulangerie/commande/validée",
				data : {
					email : email
				},
				success : function(response) {

					var trHTML = response;

					$('.preparer').html(trHTML);
				}
			});

			$.ajax({
				type : "GET",
				url : "boulangerie/commande/préparée",
				data : {
					email : email
				},
				success : function(response) {

					var trHTML = response;

					$('.solder').html(trHTML);
				}
			});
			$.ajax({
				type : "GET",
				url : "boulangerie/commande/préparée",
				data : {
					email : email
				},
				success : function(response) {

					var trHTML = response;

					$('.solder').html(trHTML);
				}

			});
			$.ajax({
				type : "GET",
				url : "boulangerie/ingredient",

				data : {
					email : email
				},
				success : function(response) {
					var trHTML = '';
					var additif;
					$.each(response, function(key, value) {

						$.ajax({
							async : false,
							type : "GET",
							url : "boulangerie/commande/dowish/ingredient",
							data : {
								email : email,
								ingredient : value.nom,
								statut : statut
							},
							success : function(data) {
								
								trHTML += '<tr><td>' + value.nom + '</td>';

								
								additif = data;
							}

						});

						$.ajax({
							async : false,
							type : "GET",
							url : "boulangerie/commande/sandwich/ingredient",
							data : {
								email : email,
								ingredient : value.nom,
								statut : statut
							},
							success : function(donnée) {
							
								trHTML += '<td>' + (donnée + additif)
										+ '</td></tr>';

								

							}

						});
					})
					$('#tablingre').append(trHTML);
				}

			});
			
			
			$.ajax({
				type : "GET",
				url : "boulangerie/sandwichs",

				data : {
					emailboulangerie : email
				},
				success : function(response) {
					var trHTML = '';
					
					$.each(response, function(key, value) {

						$.ajax({
							async : false,
							type : "GET",
							url : "boulangerie/commande/sandwich",
							data : {
								email : email,
								sandwich:value.nom,
								statut : statut
							},
							success : function(data) {
								
								trHTML += '<tr><td>' + value.nom + '</td><td>' + data + '</td></tr>';

								
								
							}

						});

					});
					$('#tablsand').append(trHTML);
					}
						
			
		});
		});			
