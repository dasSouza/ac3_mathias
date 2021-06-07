let login_usuario;
let nome_usuario;
let adm_usuario;
let nome_empresa;
let cargo_usuario;
let id_usuario;
let ide_usuario;
let fk_id_empresa;
let equipe_usuario;
let cargo_integrante_app;
let nome_integrante_app;
let equipe_integrante;

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
    ide_usuario = sessionStorage.ide_usuario_meu_app;
    fk_id_empresa = sessionStorage.fk_id_empresa_meuapp;
    equipe_usuario = sessionStorage.equipe_usuario_meuapp;
    equipe_integrante = sessionStorage.equipe_integrante_meuapp;
    cargo_integrante_app = sessionStorage.cargo_integrante_meuapp;
    nome_integrante_app = sessionStorage.nome_integrante_meuapp;

    if (login_usuario == undefined) {
        redirecionar_login();
    } else {

        if (typeof obterDadosGraficoRam === 'function') {
            obterDadosGraficoRam(id_usuario);
            carregarGrafico();
        }

        if (typeof obterDadosGraficoIDE === 'function') {
            obterDadosGraficoIDE(ide_usuario, id_usuario);
            carregarGrafico();
        }

        if (typeof recuperarIDE === 'function') {
            recuperarIDE();
        }

        if (typeof obteterQtdMquinhas === 'function') {
            obteterQtdMquinhas(fk_id_empresa, equipe_integrante)
            locateEquipeQtd(fk_id_empresa, equipe_integrante)
        }

        if (typeof obterDadosMaquina === 'function') {
            carregarDadosIntegrante(fk_id_empresa, equipe_integrante, nome_integrante_app)
            obterDadosMaquina(nome_integrante_app)
            obterDadosGraficoRamGestor(nome_integrante_app, equipe_integrante,cargo_integrante_app)
        }

        if (typeof carregarDadosGestor === 'function') {
            carregarDadosGestor(id_usuario)
        }
        

        locateEmpresa()

        typeof b_usuario0 === 'undefined' ? null : (b_usuario0.innerHTML = nome_usuario);
        typeof b_usuario1 === 'undefined' ? null : (b_usuario1.innerHTML += ` ${nome_usuario}`);
        typeof b_usuario2 === 'undefined' ? null : (b_usuario2.innerHTML += nome_usuario);
        typeof cargo2 === 'undefined' ? null : (cargo2.innerHTML += cargo_usuario);
        typeof cargo === 'undefined' ? null : (cargo.innerHTML += cargo_usuario);
        typeof empresa === 'undefined' ? null : (empresa.innerHTML += nome_empresa);
        typeof empresa2 === 'undefined' ? null : (empresa2.innerHTML += nome_empresa);
        typeof nome_equipe === 'undefined' ? null : (nome_equipe.innerHTML += equipe_integrante);
        typeof nome_integrante === 'undefined' ? null : (nome_integrante.innerHTML += nome_integrante_app)
        typeof cargo_integrante === 'undefined' ? null : (cargo_integrante.innerHTML += cargo_integrante_app)

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
