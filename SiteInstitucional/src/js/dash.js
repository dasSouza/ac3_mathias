const navigation = document.querySelector('.navigation');
const next = document.querySelector('#next');
const back = document.querySelector('#back');
const btn = document.querySelector('.btn');
const idesContainer = document.querySelector('.ides-container');
const idesContainerPart2 = document.querySelector('.ides-container-part2');
const separation = document.querySelector('.separation-ides');


document.querySelector('.toggle').onclick = function () {
    this.classList.toggle('active');
    navigation.classList.toggle('active');
}

next.addEventListener('click', function() {
    idesContainer.style.display = 'none';
    idesContainerPart2.style.display = 'flex';
});

back.addEventListener('click', function() {
    idesContainerPart2.style.display = 'none';
    idesContainer.style.display = 'flex';
});

