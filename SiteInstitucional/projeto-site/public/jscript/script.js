// Script para o header ficar fixado (Jorge e Bruno)

window.onscroll = function () { myFunction() };

// Get the header
var header = document.getElementById("headersite");

// Get the offset position of the navbar
var sticky = header.offsetTop;

// Add the sticky class to the header when you reach its scroll position. Remove "sticky" when you leave the scroll position
function myFunction() {
    if (window.pageYOffset > sticky) {
        header.classList.add("sticky");
    } else {
        header.classList.remove("sticky");
    }
}

// Limpar valores do contato
function limpar() {
    nome.value = "";
    email.value = "";
    telefone.value = "";

    alert("E-mail enviado com sucesso")
}

