$(document).ready(
		function() {

			$('#dowish').click(
					function() {

						var email, nom;
						email = $('select[name=selector]').val();
						var ingredients = [];
						nom = $("#nom").val();

						sessionStorage.removeItem("numCréa");
						$(':checkbox:checked').each(function(i) {
							ingredients[i] = $(this).val();
						});

						if (ingredients.length !== 0) {

							$.ajax({
								type : "POST",
								url : "client/dowish",
								data : {
									emailboulangerie : email,
									nom : nom,
									ingredient : ingredients.join(',')
								},
								success : function(response) {

									sessionStorage.setItem("numCréa",
											(response.numerodowish.codebarre));
									var trHTML = '';
									trHTML = response.nom;
									$('#nomd').append(trHTML);

									var trHTML = '';
									trHTML = response.prix;
									$('#prixd').append(trHTML);

									var trHTML = '';
									$.each(response.ingredients, function(key,
											value) {
										trHTML += '<dd class="ajout">'
												+ value.nom + '</dd>';

									})
									$('#nom').val('')
									$('.dl-horizontal').append(trHTML);

								}
							});

						}
					});
		});
