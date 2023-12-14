

var fichaUsada = false;
let valorTablero;
let numeroFicha;



$(document).ready(function() {
	//setup multiple rows of colours, can also add and remove while spinning but overall this is easier.
	initWheel();
	var table = document.getElementById('tablero_juego');

	var idPartida = document.getElementById("prueba");
	var clasePartida = idPartida.className;

	// Ahora 'clasePartida' contiene la clase del elemento con id "prueba"
	console.log(clasePartida);

	// First loop for merging cells with the same color or value '0'
	for (var i = 0; i < table.rows.length; i++) {
		var row = table.rows[i];

		for (var j = 0; j < row.cells.length - 1; j++) {
			var currentCell = row.cells[j];
			var nextCell = row.cells[j + 1];

			if (currentCell.innerText === nextCell.innerText &&
				(currentCell.classList.contains('rojo') || currentCell.classList.contains('negro'))) {
				// Merge cells if they have the same color
				currentCell.colSpan = 2;
				nextCell.style.display = 'none';

				// Change the content of the <span> element to "Rojo" or "Negro"
				var spanElement = currentCell.querySelector('span');
				var color = currentCell.classList.contains('rojo') ? 'Rojo' : 'Negro';
				spanElement.innerText = color;
			} else if (currentCell.innerText === '0' && nextCell.innerText === '0') {
				// Merge cells if they have the value 0
				currentCell.colSpan = 2;
				nextCell.style.display = 'none';
			}
		}
	}

	// Second loop for merging cells with value '-1'
	var foundZero = false;

	for (var i = 0; i < table.rows.length; i++) {
		var row = table.rows[i];

		for (var j = 0; j < row.cells.length - 2; j++) {
			var currentCell = row.cells[j];
			var nextCell = row.cells[j + 1];
			var nextNextCell = row.cells[j + 2];

			if (currentCell.colSpan === 2 && nextCell.style.display === 'none' && currentCell.innerText === '0') {
				// Update content based on whether it's the first or second encounter of '0'
				var spanElement = currentCell.querySelector('span');
				spanElement.innerText = foundZero ? 'Par' : 'Impar';

				// Set foundZero to true after the first encounter
				foundZero = true;
			}
		}
	}
	var lastRow = document.getElementById('tablero_juego').rows[3];
	var cellsWithMinusOne = [];
	for (var i = 0; i < lastRow.cells.length; i++) {
		var cell = lastRow.cells[i];
		var spanValue = cell.querySelector('span').innerText;
		if (spanValue === '-1') {
			cellsWithMinusOne.push(cell);
		}
	}

	// Verificar y combinar las primeras 3 celdas
	if (cellsWithMinusOne.length >= 3) {
		// Combina las primeras 3 celdas
		cellsWithMinusOne[0].colSpan = 3;
		cellsWithMinusOne[1].style.display = 'none';
		cellsWithMinusOne[2].style.display = 'none';

		// Actualiza el contenido del primer span a vacío
		var spanElement = cellsWithMinusOne[0].querySelector('span');
		spanElement.innerText = '';
	}

	// Verificar y combinar las últimas 2 celdas
	if (cellsWithMinusOne.length >= 2) {
		// Combina las últimas 2 celdas
		cellsWithMinusOne[cellsWithMinusOne.length - 2].colSpan = 2;
		cellsWithMinusOne[cellsWithMinusOne.length - 1].style.display = 'none';

		// Actualiza el contenido del último span a vacío
		var spanElementLast = cellsWithMinusOne[cellsWithMinusOne.length - 2].querySelector('span');
		spanElementLast.innerText = '';
	}
	$('button').on('click', function() {

		//Código de principal


		var outcome = Math.floor(Math.random() * 38);
		console.log(outcome)
		sendOutcomeToController(outcome,clasePartida,valorTablero,numeroFicha);
		spinWheel(outcome);

	});
});

function allowDrop(event) {
	event.preventDefault();
}

function drag(event) {
	event.dataTransfer.setData("text", event.target.id);

	// Restablecer fichaUsada a falso
	fichaUsada = false;

	// Habilitar la capacidad de arrastre para todas las fichas
	var fichas = document.querySelectorAll('.fichas img');
	fichas.forEach(function(ficha) {
		ficha.draggable = true;
		ficha.style.cursor = 'grab';

	});
}

function drop(event) {
	event.preventDefault();

	var draggedElementId = event.dataTransfer.getData("text");
	var draggedElement = document.getElementById(draggedElementId);

	// Obtener el td de destino
	var targetTd = event.target.closest('td');


	if (fichaUsada) {
		console.log("Ya has colocado una ficha. No puedes colocar más.");
		alert('Solo puedes colocar una ficha a la vez.');
		return;
	}

	// Verificar si el td de destino tiene la clase adecuada
	if (targetTd.classList.contains("verde") || targetTd.classList.contains("rojo") || targetTd.classList.contains("negro") || targetTd.classList.contains("azul") || targetTd.classList.contains("lila")) {
		// Mover la imagen al td de destino
		targetTd.appendChild(draggedElement);

		// Obtener el valor del span dentro del td
		valorTablero = targetTd.querySelector('span').textContent; //Valor que necesitamos: valor de la celda de la pos de la ficha
		// Valor de la ficha
		var fichaValor = draggedElement.getAttribute('id');
		numeroFicha = fichaValor.slice(5); //Valor que necesitamos: valor de la ficha

		console.log("Valor de la ficha: " + numeroFicha);
		// Hacer lo que quieras con el valor obtenido
		console.log("Valor del span en el td: " + valorTablero);

		// Desactivar la capacidad de arrastre para todas las fichas
		var fichas = document.querySelectorAll('.fichas img');
		fichas.forEach(function(ficha) {
			ficha.draggable = false;
			ficha.style.cursor = 'default'
		});

		fichaUsada = true;

	} else {
		console.log("La celda solo puede ser soltada en un td con la clase 'verde', 'rojo' o 'negro'");
		alert('La ficha solo puede ser soltada en una celda de número o de apuesta');
	}
}

function initWheel() {
	var $wheel = $('.roulette-wrapper .wheel'),
		row = "";

	row += "<div class='row'>";
	row += "  <div class='card black'>32<\/div>";
	row += "  <div class='card red'>1<\/div>";
	row += "  <div class='card black'>23<\/div>";
	row += "  <div class='card red'>14<\/div>";
	row += "  <div class='card black'>21<\/div>";
	row += "  <div class='card red'>2<\/div>";
	row += "  <div class='card black'>3<\/div>";
	row += "  <div class='card red'>26<\/div>";
	row += "  <div class='card black'>20<\/div>";
	row += "  <div class='card red'>13<\/div>";
	row += "  <div class='card black'>4<\/div>";
	row += "  <div class='card red'>18<\/div>";
	row += "  <div class='card black'>34<\/div>";
	row += "  <div class='card red'>12<\/div>";
	row += "  <div class='card black'>27<\/div>";
	row += "  <div class='card red'>29<\/div>";
	row += "  <div class='card black'>16<\/div>";
	row += "  <div class='card red'>36<\/div>";
	row += "  <div class='card green'>0<\/div>";
	row += "  <div class='card black'>11<\/div>";
	row += "  <div class='card red'>5<\/div>";
	row += "  <div class='card black'>22<\/div>";
	row += "  <div class='card red'>30<\/div>";
	row += "  <div class='card black'>10<\/div>";
	row += "  <div class='card red'>6<\/div>";
	row += "  <div class='card black'>9<\/div>";
	row += "  <div class='card red'>24<\/div>";
	row += "  <div class='card black'>28<\/div>";
	row += "  <div class='card red'>17<\/div>";
	row += "  <div class='card black'>35<\/div>";
	row += "  <div class='card red'>31<\/div>";
	row += "  <div class='card black'>8<\/div>";
	row += "  <div class='card red'>7<\/div>";
	row += "  <div class='card black'>15<\/div>";
	row += "  <div class='card red'>19<\/div>";
	row += "  <div class='card black'>33<\/div>";
	row += "  <div class='card red'>25<\/div>";

	row += "<\/div>";

	for (var x = 0; x < 29; x++) {
		$wheel.append(row);
	}
}

function spinWheel(roll) {

	var $wheel = $('.roulette-wrapper .wheel'),
		order = [0, 11, 5, 22, 30, 10, 6, 9, 24, 28, 17, 35, 31, 8, 7, 15, 19, 33, 25, 32, 1, 23, 14, 21, 2, 3, 26, 20, 13, 4, 18, 34, 12, 27, 29, 16, 36],
		position = order.indexOf(roll);
	console.log("Array: " + order);
	console.log("Posicion: " + roll);
	console.log("Tamaño array: " + order.length);
	//determine position where to land
	var rows = 12,
		card = 75 + 3 * 2,
		landingPosition = (rows * order.length * card) + (position * card);
	console.log("Card: " + position);
	console.log("LandingPosition: " + position);
	var randomize = Math.floor(Math.random() * 75) - (75 / 2);

	landingPosition = landingPosition + randomize;

	var object = {
		x: Math.floor(Math.random() * 70) / 100,
		y: Math.floor(Math.random() * 20) / 100
	};

	$wheel.css({
		'transition-timing-function': 'cubic-bezier(0,' + object.x + ',' + object.y + ',1)',
		'transition-duration': '2s',
		'transform': 'translate3d(-' + landingPosition + 'px, 0px, 0px)'
	});

	setTimeout(function() {
		$wheel.css({
			'transition-timing-function': '',
			'transition-duration': '',
		});

		var resetTo = -(position * card + randomize);
		$wheel.css('transform', 'translate3d(' + resetTo + 'px, 0px, 0px)');
	}, 2 * 1000);
}

function sendOutcomeToController(outcome,clasePartida,valorTablero,numeroFicha) {
	console.log(valorTablero)
	$.ajax({
		type: 'POST',
		url: '/tirada', // Reemplaza esto con la URL correcta de tu controlador
		data: { outcome: outcome,
		clasePartida: clasePartida,
		valorTablero: valorTablero,
		numeroFicha: numeroFicha},
		success: function(response) {
			// Manejar la respuesta del controlador si es necesario
			console.log('Solicitud AJAX exitosa:', response);
		},
		error: function(error) {
			console.error('Error en la solicitud AJAX:', error);
		}
	});
}