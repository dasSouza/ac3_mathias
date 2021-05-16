var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Empresa = require('../models').Empresa;

let empresas = [];

/* Recuperar usuário por login e senha */
router.get('/autenticar/:login', function (req, res, next) {
	console.log('Recuperando nome da empresa por login');

    var login = req.params.login;

	// SELECT PARA SABER EMPRESA
	let instrucaoSql = `SELECT kc_nome_comp
	FROM tb_empresa AS empresa
	JOIN tb_us_dados AS usuario 
	ON empresa.id_comp = usuario.fk_id_empresa 
	AND usuario.us_login = '${login}'`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Empresa
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log(resultado)
		empresas.push(resultado[0].dataValues.kc_nome_comp);
		console.log('Enpresas: ', empresas);
		res.json(resultado[0]);
	}).catch(erro => {
		console.log("DEU ERRO!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;