$(document)
		.ready(
				function() {

					var sousTotalSandwich = 0;
					var sandwichs = [];
					var dowishs = [];
				
					
					if(sessionStorage.getItem("nomPanier")!==null){
					
					$
							.ajax({
								type : "GET",
								url : "client/sandwich",
								data : {
									nom : (sessionStorage.getItem("nomPanier")),
									emailboulangerie : (sessionStorage
											.getItem("emailboulangeriePanier"))
								},
								success : function(response) {
									
									
									
									
									var trHTML = '';
									trHTML += '<tr><td class="listSandiwch" value="'
											+ response.nom
											+ '">'
											+ response.nom
											+ '</td><td class="text-center"><select><option>1</option></select></td><input type="text" class="form-control" id="quantité"><td class="prix">'
											+ response.prix + '</td></tr>';
									$('#panier').prepend(trHTML);
									sessionStorage.setItem("prixSandwich",
											response.prix);
									sousTotalSandwich += parseFloat(sessionStorage
											.getItem("prixSandwich"));
									sandwichs.push(response.nom);
									$('#total').html(sousTotalSandwich);

									sessionStorage.setItem("sandwichs", JSON
											.stringify(sandwichs));

								}

							});

					}
					
					if(sessionStorage.getItem("numPanier")!==null){
					$
							.ajax({
								type : "GET",
								url : "client/dowish",
								data : {
									numero : sessionStorage
											.getItem("numPanier")
								},
								success : function(response) {
									var trHTML = '';
							
									sessionStorage.setItem("prixdowish",
											response.prix);

									trHTML += '<tr><td class="listDowish" value="'
											+ response.numerodowish.codebarre
											+ '">'
											+ response.nom
											+ '</td><td class="text-center"><select><option>1</option></select></td><input type="text" class="form-control" id="quantité"><td class="prix">'
											+ response.prix + '</td></tr>';
									$('#panier').prepend(trHTML);
									sessionStorage.setItem("prixDowish",
											response.prix);
									sousTotalSandwich += parseFloat(sessionStorage
											.getItem("prixDowish"));
									dowishs
											.push(response.numerodowish.codebarre);
									console.log(dowishs);
									$('#total').html(sousTotalSandwich);

									sessionStorage.setItem("dowishs", JSON
											.stringify(dowishs));

								}

							});
					}

				});