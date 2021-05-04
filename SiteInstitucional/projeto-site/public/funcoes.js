let login_usuario;
let nome_usuario;
let adm_usuario;
let nome_empresa;
let cargo_usuario;
let id_usuario

function redirecionar_login() {
    window.location.href = '../Institucional/login.html';
}

function verificar_autenticacao() {
    login_usuario = sessionStorage.login_usuario_meuapp;
    nome_usuario = sessionStorage.nome_usuario_meuapp;
    adm_usuario = sessionStorage.administrador_usuario_meuapp;
    nome_empresa = sessionStorage.empresa_usuario_meuapp;
    cargo_usuario = sessionStorage.cargo_usuario_meuapp;
    id_usuario = sessionStorage.id_usuario_meuapp;

    if (login_usuario == undefined) {
        redirecionar_login();
    } else {
        
        if (typeof obterDadosGraficoPrimeiraVez === 'function'){
            obterDadosGraficoPrimeiraVez(id_usuario);
            carregarGrafico();
        }

        

        locateEmpresa()
        typeof b_usuario === 'undefined' ? null : (b_usuario.innerHTML = nome_usuario);
        typeof cargo === 'undefined' ? null : (cargo.innerHTML = cargo_usuario);
        typeof id_adm === 'undefined' ? null : (id_adm.style.display = "none");
        typeof empresa === 'undefined' ? null : (empresa.innerHTML = nome_empresa);

        validar_sessao();
    }

}

function admOuNao() {
    if (adm_usuario == 0) {
        window.location.href = "perfildev.html"
    } else {
        window.location.href = "cadastroAdm.html"
    }
}

function logoff() {
    finalizar_sessao();
    sessionStorage.clear();
    redirecionar_login();
}

function validar_sessao() {
    fetch(`/usuarios/sessao/${login_usuario}`, { cache: 'no-store' })
        .then(resposta => {
            if (resposta.ok) {
                resposta.text().then(texto => {
                    console.log('Sessão :) ', texto);
                });
            } else {
                console.error('Sessão :.( ');
                logoff();
            }
        });
}

function locateEmpresa() {
    fetch(`/empresas/autenticar/${login_usuario}`, { cache: 'no-store' })
    .then(resposta => {
        if (resposta.ok) {

            resposta.json().then(json => {
                sessionStorage.empresa_usuario_meuapp = json.kc_nome_comp
            });

        } else {
            console.log('Erro ao encontrar empresa');
        }
    });
}

function finalizar_sessao() {
    fetch(`/usuarios/sair/${login_usuario}`, { cache: 'no-store' });
}

function telaDashboard() {
    window.location.href = "grafico-chartjs.html"
}