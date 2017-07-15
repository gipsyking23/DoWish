$(document)
		.ready(

				function() {

					var fermée = false;
					var email;
					var heureOuverture, heurefermeture;
					$.ajax({
						async : false,
						type : "GET",
						url : "/nom",
						success : function(response) {
							$('#user').append(response);
							email = response
						}
					});
					$('#fermée').click(function() {
						if (this.checked) {
							fermée = true;
							console.log(fermée)

							heureOuverture = "00:00:00";
							heurefermeture = "00:00:00";

							console.log(heureOuverture);
							console.log(heurefermeture);
						}
					})

					$("#valider")
							.click(
									function() {
										var a, date, jour
										date = $("#date").val();
										console.log(date);
										if (heureOuverture !== "00:00:00") {

											heureOuverture = ($("#ouverture")
													.val() + ':00');
											heurefermeture = ($("#fermeture")
													.val() + ':00');
										}

										var semaine = [ "dimanche", "lundi",
												"mardi", "mercredi", "jeudi",
												"vendredi", "samedi" ];
										var a = new Date(date);
										jour = (semaine[a.getDay()]);
										console.log(jour);
										console.log(email);

										$
												.ajax({
													type : "POST",
													url : "Boulangerie/horaire",
													data : {
														date : date,
														heureOuverture : heureOuverture,
														heurefermeture : heurefermeture,
														fermée : fermée,
														emailboulangerie : email,
														jour : jour
													},
													success : function(response) {

														if (response.code == 5001) {

															var trHTML = '';
															trHTML += '<div class="alert alert-danger" role="alert">'
																	+ response.message
																	+ '</div>'
															$("#message").html(
																	trHTML);

														} else {
															location.reload();
														}
													}

												});
									});

				});