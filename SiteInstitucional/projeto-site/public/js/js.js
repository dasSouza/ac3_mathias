// Squares

const ulIDES = document.querySelector("ul.IDES");

for (let i = 0; i < 15; i++) {
  const imagems = document.createElement("img");

  const random = (min, max) => Math.random() * (max - min) + min;

  const size = Math.floor(random(60, 120));

  const randomTrunc = Math.floor(random(1, 2));

  const position = random(1, 95);

  const delay = random(5, 0.2);
  const duration = random(24, 12);

  arrayImage = [
    "img/netbeans64.png",
    "img/studio64.png",
    "img/eclipse.png",
    "img/idea64.png",
    "img/phpstorm64.png",
    "img/xcode.png",
    "img/sublime.png",
    "img/pycharm64.png",
    "img/Code.png",
    "img/devenv.png",
    "img/webstorm64.png"
  ];

  for (let value of arrayImage) {
    var randomImages = Math.floor(random(0, 11));
  }
  let imagem = arrayImage[randomImages];

  imagems.src = `${imagem}`;

  imagems.style.width = `140px`;
  imagems.style.height = `80px`;

  imagems.style.bottom = `-${size}px`;

  imagems.style.left = `${position}%`;

  imagems.style.animationDelay = `${delay}s`;

  imagems.style.animationDuration = `${duration}s`;
  imagems.style.animationTimingFunction = `cubic-bezier(${(Math.random(), Math.random(), Math.random(), Math.random())
    })`;

  ulIDES.appendChild(imagems);
}

/*MODAL*/

function openModal(mn) {
  let modal = document.getElementById(mn);
  if (typeof modal == "undefined" || modal === null) return;

  modal.style.display = "Block";
  document.body.style.overflow = "hidden";
}

function closeModal(mn) {
  let modal = document.getElementById(mn);

  if (typeof modal == "undefined" || modal === null) return;

  modal.style.display = "none";
  document.body.style.overflow = "auto";
}

// FUNCÕES LOGIN
function entrar() {
  aguardar2();
  var formulario = new URLSearchParams(new FormData(form_login));
  fetch("/usuarios/autenticar", {
    method: "POST",
    body: formulario,
  }).then((resposta) => {
    if (resposta.ok) {
      resposta.json().then((json) => {
        sessionStorage.login_usuario_meuapp = json.us_login;
        sessionStorage.administrador_usuario_meuapp = json.us_is_adm;
        sessionStorage.nome_usuario_meuapp = json.us_nome_funcionario;
        sessionStorage.cargo_usuario_meuapp = json.us_cargo;
        sessionStorage.id_usuario_meuapp = json.id_cpf;
        sessionStorage.fk_id_empresa_meuapp = json.fk_id_empresa;
        sessionStorage.equipe_usuario_meuapp = json.us_equipe;
        sessionStorage.equipe_integrante_meuapp = json.us_equipe;

        if (json.us_is_adm == 1) {
          window.location.href = "../Dash/dashgestor.html";
        } else if (json.us_is_adm == 0) {
          window.location.href = "../Dash/dashboard.html";
        }
      });
    } else {
      console.log("Erro de login!");

      resposta.text().then((texto) => {
        console.error(texto);
        finalizar_aguardar2(texto);
      });
    }
  });

  return false;
}

function aguardar2() {
  btn_login.disabled = true;
  btn_login.style.display = "none";
  img_aguarde.style.display = "block";
  div_erro.style.display = "none";
}

function finalizar_aguardar2(resposta) {
  btn_login.disabled = false;
  btn_login.style.display = "block";
  img_aguarde.style.display = "none";
  div_erro.style.display = "block";
  div_erro.innerHTML = resposta;
}

// Função validar cpf, recebe a string (strCPF) e retorna true or false.
function TestaCPF(strCPF) {
  var Soma;
  var Resto;
  Soma = 0;
  if (strCPF == "00000000000") return false;

  for (i = 1; i <= 9; i++)
    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
  Resto = (Soma * 10) % 11;

  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(9, 10))) return false;

  Soma = 0;
  for (i = 1; i <= 10; i++)
    Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
  Resto = (Soma * 10) % 11;

  if (Resto == 10 || Resto == 11) Resto = 0;
  if (Resto != parseInt(strCPF.substring(10, 11))) return false;
  return true;
}

//FUNÇÃO CADASTRO
function cadastrar(fk_id_empresa) {
  aguardar();
  var formulario = new URLSearchParams(new FormData(form_cadastro));
  fetch(`/usuarios/cadastrar/${fk_id_empresa}`, {
    method: "POST",
    body: formulario,
  }).then(function (response) {
    var regraValida = document.getElementById("Cpf").value;
    var cpfValido = /^(([0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2})|([0-9]{11}))$/;
    var strCPF = regraValida
      .split("")
      .filter((n) => Number(n) || n == 0)
      .join("");
    console.log(strCPF);

    if (TestaCPF(strCPF) == false) {
      Swal.fire({
        icon: "error",
        iconColor: '#c73535',
        title: "Por favor informe um CPF válido.",
        background: "#D6ECE1",
        confirmButtonColor: "#A3C6C1",
      });
    } else if (cpfValido.test(regraValida) == true) {
      console.log(regraValida);

      if (response.ok) {
        Swal.fire({
          icon: "success",
          iconColor: '#50d150',
          title: "Funcionário cadastrado com sucesso!",
          background: "#D6ECE1",
        });
      } else {
        console.log("Erro de cadastro!");

        response.text().then(function (resposta) {
          // div_erro.innerHTML = resposta;
          Swal.fire({
            icon: "error",
            iconColor: '#c73535',
            title: "Falha ao cadastrar funcionário!",
            background: "#D6ECE1",
            confirmButtonColor: "#A3C6C1",
          });
          console.log(resposta);
        });
        // finalizar_aguardar();
      }
    }
    finalizar_aguardar();
  });

  return false;
}

function dadosIguais() {
  let booleano = true;

  if (document.getElementById("login_cad").value == recuperaDadosIntegrante[0]
    && document.getElementById("cargo").value == recuperaDadosIntegrante[1]
    && document.getElementById("nome_cad").value == recuperaDadosIntegrante[2]
    && document.getElementById("Cpf").value == mCPF(recuperaDadosIntegrante[3])
    && document.getElementById("time").value == recuperaDadosIntegrante[4]) {
    booleano = false;
  }

  return booleano;
}

function dadosIguaisGestor() {
  console.log("to no dados")
  let booleano = true;

  if (document.getElementById("login").value == recuperaDadosGestor[0]
    && document.getElementById("senha").value == recuperaDadosGestor[1]
    && document.getElementById("nome").value == recuperaDadosGestor[2]
    && document.getElementById("timeGestor").value == recuperaDadosGestor[3]
    && document.getElementById("cargoGestor").value == recuperaDadosGestor[4]
    && document.getElementById("CpfGestor").value == mCPF(recuperaDadosGestor[5])
    && document.getElementById("admGestor").checked) {
    booleano = false;
  }

  return booleano;
}

function editarUsuario() {
  aguardar();
  var formulario = new URLSearchParams(new FormData(form_editar));
  fetch("/usuarios/editarUsuario", {
    method: "POST",
    body: formulario,
  }).then((resposta) => {
    if (!dadosIguais()) {
      Swal.fire({
        icon: "error",
        iconColor: '#c73535',
        title: "Você precisa alterar algum valor para que essa alteração seja válida.",
        background: "#D6ECE1",
        confirmButtonColor: "#A3C6C1",
      });
    } else {
      if (resposta.ok) {
        resposta.json().then((json) => {
          closeModal('dv-modal1');
          Swal.fire({
            icon: "success",
            iconColor: '#50d150',
            title: "Dados do funcionário editados com sucesso!",
            background: "#D6ECE1",
          });

          sessionStorage.nome_integrante_meuapp = document.getElementById("time").value;
          sessionStorage.nome_integrante_meuapp = document.getElementById("nome_cad").value;


          nome_equipe.innerHTML = sessionStorage.equipe_integrante_meuapp;
          nome_integrante.innerHTML = sessionStorage.nome_integrante_meuapp;
          cargo_integrante.innerHTML = sessionStorage.cargo_integrante_meuapp;
          carregarDadosIntegrante(sessionStorage.fk_id_empresa_meuapp, sessionStorage.equipe_integrante_meuapp, sessionStorage.nome_integrante_meuapp)
        });
      } else {
        console.log("Erro ao editar dado do usuário.");

        response.text().then(function (resposta) {
          Swal.fire({
            icon: "error",
            iconColor: '#c73535',
            title: "Falha ao editar os dados do funcionário! Por favor tente novamente.",
            background: "#D6ECE1",
            confirmButtonColor: "#A3C6C1",
          });
          console.log(resposta);
        });
      }
    }
    finalizar_aguardar();
  });
  return false;
}

function editarGestor() {

  if (!admGestor.checked) {
    Swal.fire({
      title: 'Você tem certeza?',
      text: "Caso clique em confirmar, você será redirecionado para a tela de login e alterará o seu nível de acesso, podendo ser alterado novamente somente por outro gestor.",
      icon: 'warning',
      iconColor: '#c73535',
      showCancelButton: true,
      confirmButtonColor: ' #88A9A7',
      cancelButtonColor: '#B73447',
      confirmButtonText: 'Sim, aceito!',
      cancelButtonText: 'Cancelar',
      background: "#D6ECE1"
    }).then((result) => {
      if (result.isConfirmed) {
        // CONFIRMOU
        editarDadosGestor()

      } else {
        // CANCELOU
        Swal.fire({
          title: 'Cancelado!',
          text: 'Você ainda pode editar os seus dados.',
          icon: 'success',
          iconColor: '#50d150',
          confirmButtonText: 'OK',
          confirmButtonColor: '#A3C6C1',
          background: "#D6ECE1"
        })
      }
    })
  } else {
    editarDadosGestor()
  }

  return false;

}

function editarDadosGestor() {
  aguardar();
  var formulario = new URLSearchParams(new FormData(form_editar_gestor));
  fetch("/usuarios/editarGestor", {
    method: "POST",
    body: formulario,
  }).then((resposta) => {

    if (!dadosIguaisGestor()) {
      Swal.fire({
        icon: "error",
        iconColor: '#c73535',
        title: "Você precisa alterar algum valor para que essa alteração seja válida.",
        background: "#D6ECE1",
        confirmButtonColor: "#A3C6C1",
      });
      console.log(resposta);
    } else {
      if (resposta.ok) {
        resposta.json().then((json) => {
          closeModal('dv-modal1');
          Swal.fire({
            icon: "success",
            iconColor: '#50d150',
            title: "Dados do funcionário editados com sucesso!",
            background: "#D6ECE1",
          });

          if (!admGestor.checked) {
            fetch(`/usuarios/sair/${sessionStorage.login_usuario_meuapp}`, { cache: 'no-store' });
            sessionStorage.clear();
            window.location.href = '../Institucional/login.html';
          }

          sessionStorage.login_usuario_meuapp = document.getElementById("login").value
          sessionStorage.nome_usuario_meuapp = document.getElementById("nome").value
          sessionStorage.administrador_usuario_meuapp = admGestor.checked ? 1 : 0;
          sessionStorage.cargo_usuario_meuapp = document.getElementById("cargoGestor").value
          sessionStorage.equipe_usuario_meuapp = document.getElementById("timeGestor").value

          carregarDadosGestor(id_usuario)
        });
      } else {
        console.log("Erro ao editar dado do usuário.");

        resposta.text().then(function (resposta) {
          Swal.fire({
            icon: "error",
            iconColor: '#c73535',
            title: "Falha ao editar os dados do funcionário! Por favor tente novamente.",
            background: "#D6ECE1",
            confirmButtonColor: "#A3C6C1",
          });
          console.log(resposta);
        });
      }
    }
    finalizar_aguardar();
  });
  return false;
}

function aguardar() {
  btn_login.disabled = true;
  btn_login.style.visibility = "hidden";
  img_aguarde.style.visibility = "visible";
}

function finalizar_aguardar() {
  btn_login.disabled = false;
  btn_login.style.visibility = "visible";
  img_aguarde.style.visibility = "hidden";
}

// MASCARA CPF
function fMasc(objeto, mascara) {
  obj = objeto;
  masc = mascara;
  setTimeout("fMascEx()", 1);
}

function fMascEx() {
  obj.value = masc(obj.value);
}

function mCPF(cpf) {
  cpf = cpf.replace(/\D/g, "");
  cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
  cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
  cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
  return cpf;
}

// SALVAR IDES
function Salvar() {
  Swal.fire({
    title: 'Você tem certeza?',
    text: "Caso clique em confirmar, alterará as IDE's visualizadas na página inicial.",
    icon: 'warning',
    iconColor: '#c73535',
    showCancelButton: true,
    confirmButtonColor: ' #88A9A7',
    cancelButtonColor: '#B73447',
    confirmButtonText: 'Sim, aceito!',
    cancelButtonText: 'Cancelar',
    background: "#D6ECE1"
  }).then((result) => {
    if (result.isConfirmed) {
      // CONFIRMOU
      validacaoIdeSelecionadas()
    } else {
      // CANCELOU
      Swal.fire({
        title: 'Cancelado!',
        text: 'Você ainda pode escolher outras IDEs!',
        icon: 'success',
        iconColor: '#50d150',
        confirmButtonText: 'OK',
        confirmButtonColor: '#A3C6C1',
        background: "#D6ECE1"
      })
    }
  })
}

function validacaoIdeSelecionadas() {
  validarDiferenca();

  if (apagarIDE.length == 0 && diferencaValue.length == 0) {
    Swal.fire({
      icon: 'error',
      title: 'Oops...',
      text: 'Você não alterou nada !😢',
      confirmButtonText: 'OK',
      confirmButtonColor: ' #88A9A7',
      background: "#D6ECE1"
    })
  }

  if (apagarIDE.length != 0) {
    for (let index = 0; index < apagarIDE.length; index++) {
      const element = apagarIDE[index];
      removeIDE(element);
    }
    var Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.addEventListener('mouseleave', Swal.resumeTimer)
      }
    })

  }

  if (diferencaValue.length != 0) {
    console.log("diferença: " + diferencaValue);
    let arrUnique = [...new Set(diferencaValue)];

    for (let index = 0; index < arrUnique.length; index++) {
      const element = arrUnique[index];
      addIDE(element);
    }

    var Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.addEventListener('mouseleave', Swal.resumeTimer)
      }
    })
  }

  diferencaValue = [];
  valuesIDE = [];
  apagarIDE = [];
  recuperaIDE = [];

  if (Toast) {
    Toast.fire({
      icon: 'success',
      iconColor: '#50d150',
      background: "#D6ECE1",
      title: 'Alteração realizada com sucesso! 😍'
    })
    document.getElementById('salvarbtn').disabled = true;
    document.getElementById('salvarbtn').style.visibility = 'hidden';
    setTimeout(function () { window.location.href = "dashboard.html" }, 3100);
  }
}

function addIDE(ideValor) {
  var idFuncionario = sessionStorage.id_usuario_meuapp;
  console.log("Entrei no addIDE");
  fetch(`/ides/cadastrarIDE/${ideValor}/${idFuncionario}`, {
    method: "POST",
  }).then((resposta) => {
    if (resposta.ok) {
      resposta.json().then((json) => {
        console.log("adicionou IDE");
      });
    } else {
      console.log("Erro ao cadastrar IDE");
    }
  });
}

function removeIDE(ideValor) {
  var idFuncionario = sessionStorage.id_usuario_meuapp;
  console.log("Entrei no removeIDE");
  fetch(`/ides/descadastrarIDE/${ideValor}/${idFuncionario}`, {
    method: "POST",
  }).then((resposta) => {
    if (resposta.ok) {
      resposta.json().then((json) => {
        console.log("apagou IDE");
      });
    } else {
      console.log("Erro ao descadastrar IDE");
    }
  });
}
