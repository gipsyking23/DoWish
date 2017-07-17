$(document)
		.ready(
				function() {
					$('#bouton_save')
							.on(
									"click",
									function(e) {
										e.preventDefault();
										var nom, prenom, email, telephone;
										nom = $('#nom').val();
										prenom = $('#prénom').val();
										email = $('#email0').val();
										telephone = $('#telephone').val();

										function validateEmail(email) {
											var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
											return re.test(email);
										}

										function validateTel(telephone) {
											var reg = /^(01|02|03|04|05|06|07|)[0-9]{8}/gi;
											return reg.test(telephone);
										}

										if ($.trim(nom) === "") {
											alert("le champ nom ne peut pas etre vide");
										} else if ($.trim(prenom) === "") {
											alert("le champ prenom ne peut pas etre vide");
										} else if ($.trim(email) === "") {
											alert("le champ email ne peut pas etre vide");
										} else if (!validateEmail(email)) {
											alert("VEUILLEZ ENTRER UN EMAIL VALIDE ! ");
										} else if ($.trim(telephone) === "") {
											alert("le champ téléphone ne peut pas etre vide");
										} else if (!validateTel(telephone)) {
											alert("veuillez entrer un telephone valide");
										}

										else {
											$
													.ajax({

														type : "POST",

														url : "/new",
														data : {
															nom : nom,
															prenom : prenom,
															email : email,
															tel : telephone
														},
														/*
														 * error: function(xhr,
														 * status, error) { var
														 * err = eval("(" +
														 * xhr.responseText +
														 * ")");
														 * alert(err.Message); },
														 */

														success : function(
																response) {

															if (response.code == 5002) {

																var trHTML = '';
																trHTML += '<div class="alert alert-danger" role="alert">'
																		+ response.message
																		+ '</div>'
																$("#message")
																		.html(
																				trHTML);
															}

															else {
																$("#formulaire")
																		.fadeOut(
																				100);
																$("#insertion")
																		.removeAttr(
																				'hidden');
																$("#message")
																		.empty();

																var nomr, prenomr, emailr, telr;

																nomr = response.nom
																prenomr = response.prenom
																emailr = response.email
																telr = 'XXXXXXXXXXXX'

																$("#rnom")
																		.html(
																				nomr);
																$("#rprenom")
																		.html(
																				prenomr);
																$("#remail")
																		.html(
																				emailr);
																$("#rtel")
																		.html(
																				telr);

															}
														}
													});
										}
									});
				});
