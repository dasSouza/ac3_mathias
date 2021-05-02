// Squares

const ulIDES = document.querySelector("ul.IDES");


for (let i = 0; i < 20; i++) {
    const imagems = document.createElement("img");

    const random = (min, max) => Math.random() * (max - min) + min;

    const size = Math.floor(random(10, 120));

    const randomTrunc = Math.floor(random(1, 2));

    const position = random(1, 95);

    const delay = random(5, 0.2);
    const duration = random(24, 12);

    arrayImage = [
        "img/netbeans.png",
        "img/androidstudio.png",
        "img/eclipse.png",
        "img/intellij.png",
        "img/phpstorm.png",
        "img/xcode.png",
        "img/sublimetext.png",
        "img/pycharm.png",
        "img/sublimetext.png",
        "img/vsstudiocode.png"
    ];

    for (let value of arrayImage) {
        var randomImages = Math.floor(random(0, 10));
    }
    console.log(randomImages);
    let imagem = arrayImage[randomImages];

    imagems.src = `${imagem}`;
    imagems.style.width = `${size}px`;

    imagems.style.height = `${size}px`;
    imagems.style.bottom = `-${size}px`
    imagems.style.borderRadius = `50%`

    imagems.style.left = `${position}%`

    imagems.style.animationDelay = `${delay}s`;

    imagems.style.animationDuration = `${duration}s`;
    imagems.style.animationTimingFunction = `cubic-bezier(${Math.random(), Math.random(), Math.random(), Math.random()})`

    ulIDES.appendChild(imagems);
}

/*MODAL*/

function openModal(mn) {
    let modal = document.getElementById(mn);
    if (typeof modal == 'undefined' || modal === null)
        return;

    modal.style.display = 'Block';
    document.body.style.overflow = 'hidden';
}

function closeModal(mn) {
    let modal = document.getElementById(mn);

    if (typeof modal == 'undefined' || modal === null)
        return;

    modal.style.display = 'none';
    document.body.style.overflow = 'auto';
}

// FUNCÕES LOGIN
function entrar() {
    aguardar2();
    var formulario = new URLSearchParams(new FormData(form_login));
    fetch("/usuarios/autenticar", {
        method: "POST",
        body: formulario
    }).then(resposta => {

        if (resposta.ok) {

            resposta.json().then(json => {

                sessionStorage.login_usuario_meuapp = json.us_login;
                sessionStorage.administrador_usuario_meuapp = json.us_is_adm;
                sessionStorage.nome_usuario_meuapp = json.us_nome_funcionario;
                sessionStorage.cargo_usuario_meuapp = json.us_cargo;

                if (json.us_is_adm == 1) {
                    window.location.href = '../Dash/dashgestor.html';
                } else if (json.us_is_adm == 0) {
                    window.location.href = '../Dash/dashboard.html';
                }
            });

        } else {

            console.log('Erro de login!');

            resposta.text().then(texto => {
                console.error(texto);
                finalizar_aguardar2(texto);
            });
        }
    });

    return false;
}

function aguardar2() {
    btn_login.disabled = true;
    btn_login.style.display = "none"
    img_aguarde.style.display = 'block';
    div_erro.style.display = 'none';
}

function finalizar_aguardar2(resposta) {
    btn_login.disabled = false;
    btn_login.style.display = "block"
    img_aguarde.style.display = 'none';
    div_erro.style.display = 'block';
    div_erro.innerHTML = resposta;
}

// Função validar cpf, recebe a string (strCPF) e retorna true or false.
function TestaCPF(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == "00000000000") return false;

    for (i = 1; i <= 9; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;

    Soma = 0;
    for (i = 1; i <= 10; i++) Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;

    if ((Resto == 10) || (Resto == 11)) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
}

//FUNÇÃO CADASTRO
function cadastrar() {
    aguardar();
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/usuarios/cadastrar", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        var regraValida = document.getElementById("Cpf").value;
        var cpfValido = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;
        var strCPF = regraValida.split("").filter(n => (Number(n) || n == 0)).join("");
        console.log(strCPF)

        if (TestaCPF(strCPF) == false) {
            Swal.fire({
                icon: 'error',
                title: 'Por favor informe um CPF válido.',
                background: '#CEE4D9',
                confirmButtonColor: '#A3C6C1'
            })
        } else if (cpfValido.test(regraValida) == true) {

            console.log(regraValida);

            if (response.ok) {

                Swal.fire({
                    icon: 'success',
                    title: 'funcionário cadastrado com sucesso!',
                    background: '#CEE4D9'
                })

            } else {

                console.log('Erro de cadastro!');

                response.text().then(function (resposta) {
                    div_erro.innerHTML = resposta;
                    Swal.fire({
                        icon: 'error',
                        title: 'Falha ao cadastrar funcionário!',
                        background: '#CEE4D9',
                        confirmButtonColor: '#A3C6C1'
                    })
                    console.log(resposta)
                });
                // finalizar_aguardar();
            }
        } 
        finalizar_aguardar();
    });

    return false;
}

function aguardar() {
    btn_login.disabled = true;
    btn_login.style.display = "none"
    img_aguarde.style.visibility = "visible"
}

function finalizar_aguardar() {
    btn_login.disabled = false;
    btn_login.style.display = "block"
    img_aguarde.style.visibility = "hidden"
}

// MASCARA CPF
function fMasc(objeto, mascara) {
    obj = objeto
    masc = mascara
    setTimeout("fMascEx()", 1)
}

function fMascEx() {
    obj.value = masc(obj.value)
}

function mCPF(cpf) {
    cpf = cpf.replace(/\D/g, "")
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
    cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2")
    cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2")
    return cpf
}