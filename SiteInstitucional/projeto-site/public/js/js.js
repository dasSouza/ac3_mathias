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
    // aguardar();
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
                sessionStorage.empresa_usuario_meuapp = json.fk_id_empresa;
                sessionStorage.cargo_usuario_meuapp = json.us_cargo;


                // window.location.href = '../Dash/dashboard.html'
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
                // finalizar_aguardar(texto);
            });
        }
    });

    return false;
}

function aguardar() {
    btn_entrar.disabled = true;
    img_aguarde.style.visibility = 'visible';
    div_erro.style.visibility = 'hidden';
}

function finalizar_aguardar(resposta) {
    btn_entrar.disabled = false;
    img_aguarde.style.visibility = 'hidden';
    div_erro.style.visibility = 'visible';
    div_erro.innerHTML = resposta;
}

//FUNÇÃO CADASTRO
function cadastrar() {
    // aguardar();
    var formulario = new URLSearchParams(new FormData(form_cadastro));
    fetch("/usuarios/cadastrar", {
        method: "POST",
        body: formulario
    }).then(function (response) {

        var regraValida = document.getElementById("Cpf").value;
        var cpfValido = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;

        if (cpfValido.test(regraValida) == true) {

            console.log("CPF Válido");
            console.log(regraValida);

            if (response.ok) {

                // window.location.href='login.html';

                Swal.fire({
                    icon: 'success',
                    title: 'funcionário cadastrado com sucesso!',
                    background: '#CEE4D9'
                })

            } else {

                console.log('Erro de cadastro!');

                response.text().then(function (resposta) {
                    // div_erro.innerHTML = resposta;
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

        } else {

            console.log("CPF Inválido");
            console.log(regraValida);

            Swal.fire({
                icon: 'error',
                title: 'Por favor informe um CPF válido.',
                background: '#CEE4D9',
                confirmButtonColor: '#A3C6C1'
            })
        }

    });

    return false;
}

function aguardar() {
    btn_entrar.disabled = true;
    img_aguarde.style.display = 'block';
    div_erro.style.display = 'none';
}

function finalizar_aguardar() {
    btn_entrar.disabled = false;
    img_aguarde.style.display = 'none';
    div_erro.style.display = 'block';
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