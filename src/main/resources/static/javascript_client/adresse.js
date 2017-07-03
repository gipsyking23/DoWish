$(document).ready(
		function() {
			$("select").change(
					function() {
						
						var email;
						email = $('select[name=selector]').val();
						

						$.ajax({
							type : "GET",
							url : "client/adresse",
							data : {
								emailboulangerie :email
							},
							success : function(response) {
								alert("form submitted: " + email);
								var trHTML = '';
								trHTML += '<p>' + response.numero + '&nbsp'
										+ response.rue + '&nbsp'
										+ response.ville + '&nbsp'
										+ response.codepostal + '</p>';

								$('#avant').html(trHTML);
							}
						});
						return false;
					});
		});
