var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Ide = require('../models').Ide;

let idesRecuperadas = []

router.post('/recuperarIDEs/:CPF', function (req, res, next) {
	console.log('Recuperando IDES CADASTRADAS');

	var cpf = req.params.CPF; // depois de .body, use o nome (name) do campo em seu formulário de login

	let instrucaoSql = `SELECT
						*
						FROM
							tb_us_ass_maquina
						WHERE 
							tb_us_maquina_id_maquina = 
							(
								SELECT DISTINCT id_maquina 
								FROM tb_us_maquina 
								WHERE fk_id_funcionario = ${cpf}
							);`
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Ide
	}).then(result => {
		console.log(`Encontrados: ${result.length}`);
		console.log(result);
		for (let u = 0; u < result.length; u++) {
			idesRecuperadas.push(result[u].dataValues.tb_ide_maquina_id_ide);
		}
		console.log('Ides: ', idesRecuperadas);
		res.json(result);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

router.post('/cadastrarIDE/:IDE/:CPF', function (req, res, next) {
	console.log('Cadastrando ides');
	
	var IDE = req.params.IDE;
	var idFuncionario = req.params.CPF;

	// INSERT
	let instrucaoSql = `IF NOT EXISTS 
    (
        SELECT
        *
        FROM
            tb_us_ass_maquina
        WHERE 
            tb_us_maquina_id_maquina = 
			(
				SELECT DISTINCT id_maquina 
				FROM tb_us_maquina 
				WHERE fk_id_funcionario = ${idFuncionario}
			)
        AND 
            tb_ide_maquina_id_ide = ${IDE}
    )
    BEGIN
        INSERT INTO tb_us_ass_maquina VALUES ((
			SELECT DISTINCT id_maquina 
			FROM tb_us_maquina 
			WHERE fk_id_funcionario = ${idFuncionario}),${IDE})
    END;`

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Ide,
		mapToModel: true
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log(resultado)
		console.log(resultado);

	}).catch(erro => {
		console.log("DEU ERRO!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

/* Descadastro de IDES */
router.post('/descadastrarIDE/:IDE/:CPF', function (req, res, next) {
	console.log('Descadastrando ides');
	
	var IDE = req.params.IDE;
	var idFuncionario = req.params.CPF;

	// INSERT
	let instrucaoSql = 
	`IF EXISTS (
		SELECT
			tb_ide_maquina_id_ide,
			tb_us_maquina_id_maquina
		FROM
			tb_us_ass_maquina
		WHERE tb_ide_maquina_id_ide = ${IDE}
		AND tb_us_maquina_id_maquina = (
			SELECT DISTINCT id_maquina 
			FROM tb_us_maquina 
			WHERE fk_id_funcionario = ${idFuncionario}
			)
		) 
	BEGIN
		DELETE FROM tb_us_ass_maquina 
		WHERE tb_us_maquina_id_maquina = (
			SELECT DISTINCT id_maquina 
			FROM tb_us_maquina 
			WHERE fk_id_funcionario = ${idFuncionario}
		) 
		AND tb_ide_maquina_id_ide = ${IDE}
	END;`

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Ide,
		mapToModel: true
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);
		console.log(resultado)
		console.log(resultado);

	}).catch(erro => {
		console.log("DEU ERRO!")
		console.error(erro);
		res.status(500).send(erro.message);
	});
});

module.exports = router;