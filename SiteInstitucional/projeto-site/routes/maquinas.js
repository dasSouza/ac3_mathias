var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Maquina = require('../models').Empresa;

/* Recuperar usuário por login e senha */
router.get('/dadosHardware/:cpf', function (req, res, next) {
	console.log('Recuperando os dados de hardware');

    var CPF = req.params.cpf;

	// SELECT PARA SABER EMPRESA
	let instrucaoSql = `SELECT 
							us_vl_ram_total,
							us_vl_disco_total,
							us_vl_cpu_total
						FROM tb_us_maquina  
						WHERE fk_id_funcionario = ${CPF}`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Maquina
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		resultado[0].dataValues.us_vl_ram_total;
		resultado[0].dataValues.us_vl_disco_total;
		resultado[0].dataValues.us_vl_cpu_total;
		console.log("Dados hardware ",resultado)
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO no Dados hardware!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

router.get('/dadosHardware/integrante/:nomeIntegrante', function (req, res, next) {
	console.log('Recuperando os dados de hardware de um integrante');

    var nomeIntegrante = req.params.nomeIntegrante;

	// SELECT PARA SABER EMPRESA
	let instrucaoSql = `SELECT DISTINCT
						us_nome_maquina,
						us_vl_ram_total,
						us_vl_disco_total,
						us_vl_cpu_total
						FROM tb_us_maquina
						WHERE fk_id_funcionario = (
							SELECT id_cpf 
							FROM tb_us_dados 
							WHERE us_nome_funcionario = '${nomeIntegrante}'
						);`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Maquina
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		console.log("Dados hardware ",resultado)
		res.json(resultado);
	}).catch(erro => {
		console.log("DEU ERRO ao recuperar os dados do hardware de um integrante")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;