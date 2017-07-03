$(document)
		.ready(
				function() {
					$('#bouton_get2')
							.click(
									function(e) {
										e.preventDefault();
										var email;

										email = $('#email3').val();
										if ($.trim(email) === "") {
											alert("le champ email est vide");
										} else {
											$
													.ajax({

														type : "GET",

														url : "/admin/boulangerie",
														data : {
															email : email
														},

														error : function(xhr,
																status, error) {
															var err = eval("("
																	+ xhr.responseText
																	+ ")");
															alert(err.Message);
														},
														success : function(
																response) {
															if (confirm("Validation 1")) {

																var trHTML = '';
																trHTML += '<h2>Voici les infos utilisateur </h2><p id="utilisateur">Email:<input type="text" value="'
																		+ response.email
																		+ '"></p><p>Nom:<input type="text" value="'
																		+ response.nom
																		+ '"><p>Tel:<input type="text" value="'
																		+ response.email
																		+ '"></p>';

																$('#avant')
																		.html(
																				trHTML);
																$
																		.ajax({

																			type : "GET",

																			url : "client/adresse",
																			data : {
																				emailboulangerie : email
																			},

																			error : function(
																					xhr,
																					status,
																					error) {
																				var err = eval("("
																						+ xhr.responseText
																						+ ")");
																				alert(err.Message);
																			},
																			success : function(
																					response) {
																				if (confirm("Validation 2")) {

																					var trHTML = '';
																					trHTML += '<p>N°:<input type="text" value="'
																							+ response.numero
																							+ '"></p><p>Rue:<input type="text" value="'
																							+ response.rue
																							+ '"></p><p>Ville:<input type="text" value="'
																							+ response.ville
																							+ '"></p><p>CP:<input type="text" value="'
																							+ response.codepostal
																							+ '"></p><button type="submit" value="submit" id="bouton_" class="btn btn-primary">modifier</button>';

																					$(
																							'#apres')
																							.html(
																									trHTML);
																					$(
																							'#myModal2')
																							.modal(
																									'hide');
																					$(
																							'.modal-backdrop')
																							.hide();
																				}
																			}
																		});
															}
														}
													});

										}
									});
				});

$(document)
		.ready(
				function() {
					$('#bouton_get')
							.click(
									function(e) {
										e.preventDefault();
										var email;

										email = $('#email2').val();
										if ($.trim(email) === "") {
											alert("le champ email est vide");
										} else {
											$
													.ajax({

														type : "GET",

														url : "/admin/boulangerie",
														data : {
															email : email
														},

														error : function(xhr,
																status, error) {
															var err = eval("("
																	+ xhr.responseText
																	+ ")");
															alert(err.Message);
														},
														success : function(
																response) {
															if (confirm("Validation 1")) {

																var trHTML = '';
																trHTML += '<h2>Voici les infos utilisateur </h2><p id="utilisateur">'
																		+ response.email
																		+ '</p><p>Nom:'
																		+ response.nom
																		+ '</p><p>Tel:'
																		+ response.tel
																		+ '</p>';

																$('#avant')
																		.html(
																				trHTML);
																$
																		.ajax({

																			type : "GET",

																			url : "client/adresse",
																			data : {
																				emailboulangerie : email
																			},

																			error : function(
																					xhr,
																					status,
																					error) {
																				var err = eval("("
																						+ xhr.responseText
																						+ ")");
																				alert(err.Message);
																			},
																			success : function(
																					response) {
																				if (confirm("Validation 2")) {

																					var trHTML = '';
																					trHTML += '<p>N°:'
																							+ response.numero
																							+ '</p><p>Rue:'
																							+ response.rue
																							+ '</p><p>Ville:'
																							+ response.ville
																							+ '</p><p>Code postal:'
																							+ response.codepostal
																							+ '</p><button type="submit" value="submit" id="bouton_delete" class="btn btn-primary">supprimer</button>';

																					$(
																							'#apres')
																							.html(
																									trHTML);
																					$(
																							'#myModal1')
																							.modal(
																									'hide');
																					$(
																							'.modal-backdrop')
																							.hide();
																				}
																			}
																		});
															}
														}
													});

										}
									});

					$('#apres').on('click', '#bouton_delete', function() {

						var email;

						email = $('#utilisateur').text();

						console.log(email);
						$.ajax({

							type : "GET",
							url : "admin/boulangerie/off",
							data : {
								email : email
							},
							error : function(xhr, status, error) {
								var err = eval("(" + xhr.responseText + ")");
								alert(err.Message);
							},
							success : function(response) {
								console.log("macho macho")

							}
						});
						
					});
						
						$(document).ready(function () {
						       $('#bouton_post').on("click",function (e) {
						           e.preventDefault();
						           var nom, prenom, email,telephone, numero, rue, codePostal, ville; 
						           nom = $('#nom').val();
						          
						           email = $('#email').val();
						           telephone = $('#telephone').val();
						           numero =  $('#numero').val();
						           rue = $('#rue').val();
						           ville = $('#ville').val();
						           codePostal= $('#codepostal').val();
						           
						           
						           if($.trim(nom) === ""){
						               alert("le champ nom ne peut pas etre vide");
						           }
						         
						               else if($.trim(email) === ""){
						                   alert("le champ email ne peut pas etre vide");
						               }

						                   else if($.trim(telephone) === ""){
						                       alert("le champ prenom ne peut pas etre vide");
						               
						           }
						                   else {
						                	   $.ajax({
						                	
						                		
						                           type:"POST",
						                          
						                           url:"admin/boulangerie",
						                           data:{nom:nom,email:email,tel:telephone},
						                          
						                           error: function(xhr, status, error) {
						                        	   var err = eval("(" + xhr.responseText + ")");
						                        	   alert("ca rentre pas");
						                        	 },
						                   success: function (response) {
						                       if (confirm("Validation")){
						                    	   
						                    	  

						   						$.ajax({
						   							type : "POST",
						   							url : "admin/boulangerie/adresse",
						   							data : {
						   								numero:numero, rue:rue, ville:ville, codepostal:codePostal, emailboulangerie:email
						   							},
						   							success : function(response) {
						   								alert("form submitted: " +email);
						   								$(
														'#myModal')
														.modal(
																'hide');
												$(
														'.modal-backdrop')
														.hide();
						   							
						   							var trHTML = '';
													trHTML += '<h2>La boulangerie a bien été ajouté </h2><p id="utilisateur">email:'
															+ response.boulangerie.email
															+ '</p><p>Nom:'
															+ response.boulangerie.nom
															+ '</p><p>Tel:'
															+ response.boulangerie.tel
															+ '</p>';

													$('#avant')
															.html(
																	trHTML);
						   							var trHTML = '';
													trHTML += '<p>N°:'
															+ response.numero
															+ '</p><p>Rue:'
															+ response.rue
															+ '</p><p>Ville:'
															+ response.ville
															+ '</p><p>CP:'
															+ response.codepostal
															+ '</p>'

													$(
															'#apres')
															.html(
																	trHTML);}
						   						});
						                    	  
						                    	   
						                 
						                    	   
						                    	
						                    	   
						                       }
						                   }
						               });
						           }
						       });
						    });

						
						
						
						
						
						
						
					});

			
