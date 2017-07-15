$(document).ready(function() {
	var nom = "";

	$("#insérer").click(function() {

		nom = $('input[type="radio"]:checked').val();

		if ($.trim(nom) !== "") {
			sessionStorage.setItem("nomPanier", nom);
			emailboulangerie = $('select[name=selector]').val();
			sessionStorage.setItem("emailboulangeriePanier", emailboulangerie);
			$("input:radio").prop('checked', false);
		}
	});

	$("#ajouter").click(function() {
		numero = sessionStorage.getItem("numCréa");
		sessionStorage.setItem("numPanier", numero);
		$("input:checkbox").prop('checked', false);
		$('#nomd,#prixd,.ajout').empty();
	});

});
