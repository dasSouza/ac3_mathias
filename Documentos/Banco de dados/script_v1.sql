SELECT * FROM tb_us_maquina AS maq
JOIN tb_us_dados AS us
ON maq.fk_id_funcionario = us.id_cpf;

SELECT DISTINCT us_ide_ram, fk_id_maquina, us_ide_nome_processo
FROM tb_processos_ide AS ide
	JOIN tb_us_maquina AS maq
	ON ide.fk_id_maquina = 1;

SELECT DISTINCT us_ide_ram, fk_id_maquina, us_ide_nome_processo
FROM tb_processos_ide AS ide
	JOIN tb_us_maquina AS maq
	ON ide.fk_id_maquina = (id_maq);

SELECT DISTINCT us_ide_ram, us_ide_disco, us_ide_cpu, us_dt_hr_start_IDE, us_dt_hr_end_IDE, us_ide_nome_processo,fk_id_maquina
FROM tb_processos_ide AS ide
	JOIN tb_us_maquina AS maq
	ON ide.fk_id_maquina = (id_maq);

SELECT DISTINCT us_nome_funcionario, us_equipe, fk_id_empresa
FROM tb_us_dados AS usuario
	JOIN tb_us_maquina AS maq
	ON usuario.us_equipe = 'Paquetá'
	AND fk_id_empresa = 1;