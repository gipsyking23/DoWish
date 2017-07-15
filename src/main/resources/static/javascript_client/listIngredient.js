$(document)
		.ready(
				function() {
					var email;
					if ((sessionStorage.getItem("nomPanier") !== null)
							|| (sessionStorage.getItem("numPanier") !== null)) {
						email = (sessionStorage
								.getItem("emailboulangeriePanier"));
						$("#bouton_post").prop('disabled', true);
						$('#liste').prop('disabled', true);
						$
								.ajax({
									type : "GET",
									url : "client/boulangerie/ingredient",
									data : {
										email : email
									},
									success : function(response) {
										var trHTML = '';
										$
												.each(
														response,
														function(key, value) {
															trHTML += '<tr><td>'
																	+ value.nom
																	+ '</td><td>'
																	+ value.prix
																	+ '&nbsp<input type="checkbox" value="'
																	+ value.nom
																	+ '"></td></tr>';
														});
										$('#tablingre').append(trHTML);

									}

								});

					}

					$("#bouton_post")
							.click(
									function() {
										// validate and process form here

										$("#bouton_post")
												.prop('disabled', true);
										email = $('select[name=selector]')
												.val();
										$('#liste').prop('disabled', true);

										$
												.ajax({
													type : "GET",
													url : "client/boulangerie/ingredient",
													data : {
														email : email
													},
													success : function(response) {
														var trHTML = '';
														$
																.each(
																		response,
																		function(
																				key,
																				value) {
																			trHTML += '<tr><td>'
																					+ value.nom
																					+ '</td><td>'
																					+ value.prix
																					+ '&nbsp<input type="checkbox" value="'
																					+ value.nom
																					+ '"></td></tr>';
																		});
														$('#tablingre').append(
																trHTML);

													}

												});
									});
				});
