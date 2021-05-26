var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Ide = require('../models').Ide;


/* Cadastro de IDES */
// router.post('/cadastrarIDE', function (req, res, next) {
// 	console.log('Cadastrando ides');

// 	Ide.({
// 		tb_us_maquina_id_maquina: 1,
// 		tb_ide_maquina_id_ide: 2
// 	}).then(resultado => {
// 		console.log(`Registro criado: ${resultado}`)
// 		res.send(resultado);
// 	}).catch(erro => {
// 		console.error(erro);
// 		res.status(500).send(erro.message);
// 	});
// });

router.post('/cadastrarIDE', function (req, res, next) {
	console.log('Cadastrando ides');
	
	// INSERT
	let instrucaoSql = `IF NOT EXISTS 
	(
		SELECT
		*
		FROM
			tb_us_ass_maquina
		WHERE 
			tb_us_maquina_id_maquina = 1
		AND 
			tb_ide_maquina_id_ide = 1
	)
	BEGIN
		INSERT INTO tb_us_ass_maquina VALUES (1,1)
	END;`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Ide
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log(resultado)
		res.json(resultado[0]);
		console.log(resultado);

	}).catch(erro => {
		console.log("DEU ERRO!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});



/* Descadastro de IDES */
router.post('/descadastrarIDE', function (req, res, next) {
	console.log('Cadastrando IDES');

	ide.create({
		id_cpf: cpf,
		us_nome_funcionario: req.body.nome_cad,
		us_login: req.body.login_cad,
		us_senha: req.body.senha_cad,
		us_cargo: req.body.cargo,
		us_is_adm: req.body.adm = req.body.adm == undefined ? 0 : 1,
		fk_id_empresa: sessionStorage.fk_id_empresa_meu_app
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});


module.exports = router;