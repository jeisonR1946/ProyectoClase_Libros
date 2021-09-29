

$(document).ready(function() {

	cargarLibros();
	function cargarLibros() {

		$.ajax({
			type: "post",
			url: "Libro",
			dataType: "json",
			success: function(result) {
				console.log(result);
				let datos=document.querySelector(".ListaLibros")
				console.log(datos)
				datos.innerHTML=''
				for(let i of result ){
					datos.innerHTML+=`<option value='${i.ISBN}'>${i.Titulo} </option>`;
				}
			}
		});

	}

});