$(document)
		.ready(
				function() {
					var email;

					$.ajax({

						async : false,
						type : "GET",
						url : "/nom",
						success : function(response) {

							$('#user').html(response);
							$('#paire').click(function(e) {
								e.preventDefault();
							});

						}
					});

					$("#bouton_post")
							.click(
									function(event) {
										event.preventDefault();
										var email, password;
										email = $('#email').val()
										password = $('#password').val();
										$
												.ajax({
													data : {
														username : email,
														password : password
													},
													timeout : 1000,
													type : 'POST',
													url : '/login'

												})
												.done(
														function(data,
																textStatus,
																jqXHR) {

															$('#myModal')
																	.modal(
																			'hide');
															$('.modal-backdrop')
																	.hide();
															$
																	.ajax({

																		type : "GET",
																		url : "/role",
																		success : function(
																				response) {

																			if (response == 1) {
																				window.location.href = "http://localhost:8080/boulangerie.html"
																			}

																			else if (response == 2) {
																				window.location.href = "http://localhost:8080/commandes.html"
																			} else if (response == 3) {
																				window.location.href = "http://localhost:8080/admin.html"
																			}
																		}
																	})

														})
												.fail(
														function(jqXHR,
																textStatus,
																errorThrown) {
															alert('Mot de passe ou email incorrect ! Authentification impossible');
														});
									});
				});
