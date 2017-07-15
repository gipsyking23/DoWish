$(document).ready(
		function() {

			var aujourdhui = new Date();
			var email;

			$.ajax({
				async : false,
				type : "GET",
				url : "/nom",
				success : function(response) {

					email = response
				}
			});

			$.ajax({
				type : "GET",
				async : false,
				url : "Boulangerie/horaire",
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
							trHTML += '<tr><td>' + value.jour.nom + '</td><td>'
									+ value.date + '</td><td>' + open
									+ '</td><td>' + close + '</td><td>'
									+ réponse + '</td><td></td></tr>';
						}
					});
					$('#planning').append(trHTML);

				}

			});

		})
