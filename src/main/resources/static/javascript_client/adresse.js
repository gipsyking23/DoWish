$(document).ready(
		function() {
			$("select").change(
					function() {
						var aujourdhui = new Date();
						var email;
						email = $('select[name=selector]').val();

						$.ajax({
							type : "GET",
							url : "client/adresse",
							data : {
								emailboulangerie : email
							},
							success : function(response) {
								
								var trHTML = '';
								trHTML += '<p>' + response.numero + '&nbsp'
										+ response.rue + '&nbsp'
										+ response.ville + '&nbsp'
										+ response.codepostal + '</p>';

								$('#avant').html(trHTML);
							}
						});
						$.ajax({
							type : "GET",
							async : false,
							url : "Client/horaire",
							data : {
								emailBoulangerie : email
							},
							success : function(response) {
								var trHTML = '';

								var réponse, open, close;
								$.each(response, function(key, value) {
									if (value.fermeture) {
										réponse = "ouvert";
									} else {
										réponse = "<b>fermée</b>"
									}

									if (value.ouverture == null) {
										open = "-";
										close = "-";
									} else {
										open = value.ouverture;
										close = value.fermeture;
									}

									if (new Date(value.date) >= aujourdhui) {
										trHTML += '<tr><td>' + value.jour.nom
												+ '</td><td>' + value.date
												+ '</td><td>' + open
												+ '</td><td>' + close
												+ '</td><td>' + réponse
												+ '</td><td></td></tr>';
									}
								});
								$('#planning').html(trHTML);

							}

						});

					});
		});
