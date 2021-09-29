

$(document).ready(function() {
	let mensaje = "Hola mundo..";
	alert(mensaje);
	console.log(mensaje);

	function Sumar() {

		var n1 = parseInt(document.getElementById("n1").value);
		var n2 = parseInt(document.getElementById("n2").value);
		var suma = n1 + n2
		console.log("la suma es: " + suma)
		var h2 = document.getElementById("h2")
		h2.innerHTML = "la suma es: " + suma;

	}
	
	$('.suma').on('click', function(){
		Sumar();
	});


});



