$(document).ready(function () {
  //setup multiple rows of colours, can also add and remove while spinning but overall this is easier.
  initWheel();

  $('button').on('click', function () {
    var outcome = Math.floor(Math.random() * 38);
    console.log(outcome)
    spinWheel(outcome);
    
  });
});

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
  console.log("Posicion: "+roll);
  console.log("Tamaño array: "+order.length);
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

  setTimeout(function () {
    $wheel.css({
      'transition-timing-function': '',
      'transition-duration': '',
    });

    var resetTo = -(position * card + randomize);
    $wheel.css('transform', 'translate3d(' + resetTo + 'px, 0px, 0px)');
  }, 2 * 1000);
}