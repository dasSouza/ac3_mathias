var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Leitura = require('../models').Leitura;

/* Recuperar as últimas N leituras */
router.get('/ultimas/:idprocessos', function (req, res, next) {

	// quantas são as últimas leituras que quer? 8 está bom?
	const limite_linhas = 1;

	var idprocessos = req.params.idprocessos;

	console.log(`Recuperando as ultimas ${limite_linhas} leituras`);

	const instrucaoSql = `select top ${limite_linhas} 
						us_dt_hr_end_IDE,
						us_ide_ram,
						us_ide_cpu,
						us_ide_disco
						from tb_processos_ide
						order by id_processos desc`;
						
	sequelize.query(instrucaoSql, {
		model: Leitura,
		mapToModel: true
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			console.log(resultado)
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

router.get('/tempo-real/:idprocessos', function (req, res, next) {
	console.log('Recuperando caminhões');

	//var idprocessos = req.body.idprocessos; // depois de .body, use o nome (name) do campo em seu formulário de login
	var idprocessos = req.params.idprocessos;

	let instrucaoSql = `select top 2 us_dt_hr_processo, us_ide_total_processo from tb_processos_ide where fk_id_ide = ${idprocessos} order by id_processos desc`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

module.exports = router;