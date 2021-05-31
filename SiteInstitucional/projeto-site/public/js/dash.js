const navigation = document.querySelector('.navigation');
const next = document.querySelector('#next');
const back = document.querySelector('#back');
const btn = document.querySelector('.btn');
const idesContainer = document.querySelector('.ides-container');
const idesContainerPart2 = document.querySelector('.ides-container-part2');

document.querySelector('.toggle').onclick = function () {
  this.classList.toggle('active');
  navigation.classList.toggle('active');
}

function darkMode() {
  var element = document.querySelector('.page');
  
  element.classList.toggle("dark-mode");
}

next.addEventListener('click', function () {
  idesContainer.style.display = 'none';
  idesContainerPart2.style.display = 'flex';
});

back.addEventListener('click', function () {
  idesContainerPart2.style.display = 'none';
  idesContainer.style.display = 'flex';
});

// Para que o password não fique exposto apos mover a imagem.
document.getElementById('olho').addEventListener('mousemove', function () {
  document.getElementById('senha_cad').type = 'password';
});

/* teste */

// Set the date we're counting down to
var countDownDate = new Date("Apr 10, 2021 15:37:25").getTime();

// Update the count down every 1 second
var x = setInterval(function () {

  // Get todays date and time
  var now = new Date().getTime();

  // Find the distance between now an the count down date
  var distance = countDownDate - now;

  // Time calculations for days, hours, minutes and seconds
  var days = Math.floor(distance / (1000 * 60 * 60 * 24));
  var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);

  // Display the result in an element with id="demo"
  demo.innerHTML = days + "d " + hours + "h "
    + minutes + "m " + seconds + "s ";

  // If the count down is finished, write some text
  if (distance < 0) {
    clearInterval(x);
    document.getElementById('demo').innerHTML = "EXPIRED";
  }
}, 1000);


