var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;
var Empresa = require('../models').Empresa;

let sessoes = [];
/* Recuperar usuário por login e senha */
router.post('/autenticar', function (req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var login = req.body.login; // depois de .body, use o nome (name) do campo em seu formulário de login
	var senha = req.body.senha;

	let instrucaoSql = `select * from tb_us_dados where us_login='${login}' and us_senha='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.us_login);
			console.log('sessoes: ', sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Cadastrar usuário */
router.post('/cadastrar/:fk_id_empresa', function (req, res, next) {
	console.log('Criando um usuário');

	var fk_id_empresa = req.params.fk_id_empresa

	var cpf = req.body.cpf.split("").filter(n => (Number(n) || n == 0)).join("");

	Usuario.create({
		id_cpf: cpf,
		us_nome_funcionario: req.body.nome_cad,
		us_login: req.body.login_cad,
		us_senha: req.body.senha_cad,
		us_cargo: req.body.cargo,
		us_is_adm: req.body.adm = req.body.adm == undefined ? 0 : 1,
		us_equipe: req.body.time,
		fk_id_empresa: fk_id_empresa
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


/* Verificação de usuário */
router.get('/sessao/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Verificando se o usuário ${login} tem sessão`);

	let tem_sessao = false;
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] == login) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${login} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}

});

// Encontra a quantidade e integrantes em um equipe
router.get('/equipe/:idEmpresa/:equipe', function (req, res, next) {
	console.log('Recuperando quantidade de integrantes na equipe');

	var idEmpresa = req.params.idEmpresa;
	var equipe = req.params.equipe;

	let instrucaoSql = `SELECT 
						COUNT(us_equipe) as somaEq 
						from tb_us_dados 
						WHERE us_equipe = '${equipe}'
						and fk_id_empresa = ${idEmpresa};
	`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log(resultado)
		res.json(resultado[0]);
	}).catch(erro => {
		console.log("DEU ERRO!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

// Encontra todas informmações da equipe
router.post('/equipe/integrantes/:idEmpresa/:equipe', function (req, res, next) {
	console.log('Recuperando quantidade de integrantes na equipe');

	var idEmpresa = req.params.idEmpresa;
	var equipe = req.params.equipe;

	let instrucaoSql = `SELECT 
						us_dt_hr_log, 
						usuario.us_cargo, 
						usuario.us_nome_funcionario
						FROM tb_log_hardware
						JOIN tb_us_dados AS usuario
						JOIN tb_us_maquina AS maq
						ON usuario.id_cpf = maq.fk_id_funcionario
						ON maq.id_maquina = fk_id_maq
							AND usuario.us_equipe = '${equipe}'
							AND usuario.us_is_adm = 0
							AND usuario.fk_id_empresa = ${idEmpresa};`
		
	// `SELECT
	// 					us_nome_funcionario,
	// 					us_cargo
	// 					FROM tb_us_dados
	// 					WHERE us_equipe = '${equipe}'
	// 						and fk_id_empresa = ${idEmpresa}
	// 						and us_is_adm = 0;`

console.log(instrucaoSql);

sequelize.query(instrucaoSql, {
	model: Usuario
}).then(resultado => {
	console.log(`Encontrados: ${resultado.length}`);
	console.log(resultado);
	res.json(resultado);
}).catch(erro => {
	console.log("DEU ERRO!")
	console.error(erro);
	res.status(500).send(erro.message);
});
});

// Trás todos os dados de um integrante da equipe
router.get('/modalIntegrantes/:idEmpresa/:equipe/:nomeIntegrante', function (req, res, next) {
	console.log('Recuperando quantidade de integrantes na equipe');

	var idEmpresa = req.params.idEmpresa;
	var equipe = req.params.equipe;
	var nomeIntegrante = req.params.nomeIntegrante
	let instrucaoSql = `SELECT 
						us_login,
						us_cargo,
						us_nome_funcionario,
						id_cpf,
						us_equipe,
						us_is_adm
						FROM tb_us_dados 
						WHERE us_equipe = '${equipe}'
						AND fk_id_empresa = ${idEmpresa}
						AND us_nome_funcionario = '${nomeIntegrante}'`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log("Dados do integrante: ", resultado);
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO ao recuperar os dados do integrante")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

// Trás todos os dados do gestor da equipe
router.get('/modalGestor/:idUsuario', function (req, res, next) {
	console.log('Recuperando dados do gestor');

	var idUsuario = req.params.idUsuario;
	let instrucaoSql = `SELECT 
						us_login,
						us_senha,
						us_nome_funcionario,
						us_equipe,
						us_cargo,
						id_cpf,
						us_is_adm
						FROM tb_us_dados 
						WHERE id_cpf = ${idUsuario}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log("Dados do gestor: ", resultado);
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO ao recuperar os dados do gestor")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

// Editar dados do usuário
router.post('/editarUsuario', function (req, res, next) {
	console.log('editando dados do usuário');

	var cpf = req.body.cpf.split("").filter(n => (Number(n) || n == 0)).join("");
	var cargo = req.body.cargo;
	var nome = req.body.nome_cad;
	var equipe = req.body.time;
	var adm = req.body.adm == undefined ? 0 : 1;

	let instrucaoSql = `UPDATE tb_us_dados 
						SET us_nome_funcionario = '${nome}',
						us_cargo = '${cargo}', 
						us_equipe = '${equipe}',
						us_is_adm = '${adm}'
						WHERE id_cpf = ${cpf}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log("Dados do integrante alterados: ", resultado);
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO ao alterar os dados do integrante")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


// Editar dados do geetor
router.post('/editarGestor', function (req, res, next) {
	console.log('editando dados do gestor');

	var cpf = req.body.cpf.split("").filter(n => (Number(n) || n == 0)).join("");
	var loginAdm = req.body.login_cad;
	var senhaAdm = req.body.senha_cad;
	var cargo = req.body.cargo;
	var nome = req.body.nome_cad;
	var equipe = req.body.time;
	var adm = req.body.adm == undefined ? 0 : 1;

	let instrucaoSql = `UPDATE tb_us_dados 
						SET us_nome_funcionario = '${nome}',
						us_login = '${loginAdm}',
						us_senha = '${senhaAdm}',
						us_cargo = '${cargo}', 
						us_equipe = '${equipe}',
						us_is_adm = '${adm}'
						WHERE id_cpf = ${cpf}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log("Dados do gestor alterados: ", resultado);
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO ao alterar os dados do gestor")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Logoff de usuário */
router.get('/sair/:login', function (req, res, next) {
	let login = req.params.login;
	console.log(`Finalizando a sessão do usuário ${login}`);
	let nova_sessoes = []
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] != login) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${login} finalizada com sucesso!`);
});


/* Recuperar todos os usuários */
router.get('/', function (req, res, next) {
	console.log('Recuperando todos os usuários');
	Usuario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);

		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;
