$(document)
		.ready(
				function() {

					var emailclient, emailboulangerie, aujourdhui;
					aujourdhui = new Date();
					emailboulangerie = (sessionStorage
							.getItem("emailboulangeriePanier"));
					$.ajax({

						async : false,
						type : "GET",
						url : "/nom",
						success : function(response) {
							emailclient = response;
							$('#user').append(response);

						}
					})

					$.ajax({
						type : "GET",
						async : false,
						url : "Client/horaire",
						data : {
							emailBoulangerie : emailboulangerie
						},
						success : function(response) {
							var trHTML = '';

							var réponse, open, close;
							$.each(response, function(key, value) {
								if (value.fermée) {
									réponse = "<b>fermée</b>";
								} else {
									réponse = "ouvert"
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
											+ '</td><td>' + open + '</td><td>'
											+ close + '</td><td>' + réponse
											+ '</td><td></td></tr>';
								}
							});
							$('#planning').html(trHTML);

						}

					});

					$("#valider")
							.click(
									function() {
										var dateretrait, heureretrait, sandwichs, codedowishs, dayoff, opentime, closetime;
										opentime = "";
										closetime = "";
										dateretrait = $("#date").val();
										heureretrait = $("#heure").val()
												+ ':00';

										var sandwichs = [];
										sandwichs = JSON.parse(sessionStorage
												.getItem("sandwichs"));

										var dowishs = [];
										dowishs = JSON.parse(sessionStorage
												.getItem("dowishs"));

										$
												.ajax({

													async : false,
													type : "GET",
													url : "Client/ouvert",
													data : {
														date : dateretrait,
														emailBoulangerie : emailboulangerie
													},

													success : function(response) {
														dayoff = response.fermée;
														console.log(dayoff);

														opentime = response.ouverture;
														console.log(opentime);
														closetime = response.fermeture;
														console.log(closetime);
														console
																.log(heureretrait);
													}
												});

										if (dayoff == false) {

											$
													.ajax({
														type : "POST",
														url : "client/panier",
														data : {
															dateretrait : dateretrait,
															heureretrait : heureretrait,
															emailclient : emailclient,
															sandwich : sandwichs
																	.join(','),
															codedowish : dowishs
																	.join(','),
															emailboulangerie : emailboulangerie
														},
														success : function(
																response) {

															

																var ref = '';
																ref = response.numeropanier.référence;
																sessionStorage
																		.setItem(
																				"ref",
																				ref);
																console
																		.log(ref);
																var trHTML = '';
																trHTML += '<div class="row"><div class="thumbnail"><img src="image/basket-1710064_960_720.png"  width="400px" height="300px" alt="panier"><div class="caption"><h3>RECAPITULATIF</h3><p><b>date de retrait:</b>'
																		+ response.dateretrait
																		+ '</p><p><b>heure de retrait:</b>'
																		+ response.heureretrait
																		+ '</p>'
																$
																		.each(
																				response.dowishs,
																				function(
																						clé,
																						valeur) {
																					trHTML += '<p><b>dowish:</b>'
																							+ valeur.nom
																							+ '&nbsp<b>ingrédients:</b>';
																					$
																							.each(
																									this.ingredients,
																									function(
																											c,
																											v) {
																										trHTML += '&nbsp'
																												+ v.nom
																												+ '&nbsp';
																									});
																					trHTML += '&nbsp <b>prix:</b>'
																							+ valeur.prix
																							+ '</p>'
																				});
																$
																		.each(
																				response.sandwichs,
																				function(
																						clé,
																						valeur) {
																					trHTML += '<p><b>sandwich:</b>'
																							+ valeur.nom
																							+ '&nbsp<b>ingrédients:</b>'
																					$
																							.each(
																									this.ingredients,
																									function(
																											c,
																											v) {
																										trHTML += ',&nbsp'
																												+ v.nom
																												+ '&nbsp';
																									});
																					trHTML += '&nbsp <b>prix:</b>'
																							+ valeur.prix
																							+ '</p>'
																				});
																trHTML += '<p><b>total:</b>'
																		+ response.total
																		+ 'eu</p><div id="footer"><textarea class="form-control text-center" placeholder="Ajouter un commentaire à votre réservation" rows="2"></textarea><p><a id="modifier" class="btn btn-primary" role="button">Modifier</a> <a id="envoyer"class="btn btn-default" role="button">Envoyer</a></p></div></div></div></div></div>'
																$('#recap')
																		.html(
																				trHTML);

															
															
														}

													});
										} else {
											var trHTML = '<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Attention!</strong> A votre jour ou heure de retrait, la boulangerie est fermée</div>';
											$('#erreur').html(trHTML);
										}
									});

					$('#recap')
							.on(
									'click',
									'#envoyer',
									function() {
										var commentaire, référence;
										commentaire = $("textarea").val();

										référence = sessionStorage
												.getItem("ref");

										$
												.ajax({
													type : "POST",
													url : "client/commande",
													data : {
														commentaire : commentaire,
														email : emailboulangerie,
														référence : référence
													},

													success : function(response) {

														if (confirm) {

															var trHTML = '';
															trHTML += '<p><b>numéro de commande:</b>'
																	+ response.numero.numero
																	+ '</p><p><b>effectuer le :</b>'
																	+ response.date
																	+ '</p><p><b>statut:</b>'
																	+ response.statut.nom
																	+ '</p><p><b>commentaire:</b>'
																	+ response.commentaire
																	+ '</p>  <p><a href="commandes.html" class="btn btn-primary" role="button">Voir mes commandes</a></p>'
															$('#footer').html(
																	trHTML);
															$('.page-header')
																	.html(
																			'<h1>VOTRE RESERVATION</h1>')
															sessionStorage
																	.clear();
														}
														;
													}
												});

									});

				});