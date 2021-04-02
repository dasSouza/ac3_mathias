CREATE TABLE tb_empresa (
	id_comp INT IDENTITY(1,1) PRIMARY KEY,
	kc_nome_comp VARCHAR(255) NOT NULL,
	kc_cep_comp CHAR(8) NOT NULL,
	kc_cnpj_comp CHAR(14) NOT NULL,
	kc_telefone_comp CHAR(13) NOT NULL,
	kc_email_comp VARCHAR(255)
)

CREATE TABLE tb_us_dados (
	id_cpf INT IDENTITY(1,1) PRIMARY KEY,
	us_nome_funcionario VARCHAR(255),
	us_cargo VARCHAR(50),
	us_login VARCHAR(50),
	us_senha VARCHAR(30),
	us_is_adm TINYINT,
	fk_id_empresa INT,
	CONSTRAINT fk_id_empresa FOREIGN KEY (fk_id_empresa) REFERENCES tb_empresa (id_comp)
)

CREATE TABLE tb_us_maquina(
	id_maquina INT IDENTITY(1,1) PRIMARY KEY,
	us_nome_maquina VARCHAR(100),
	us_vl_ram DECIMAL(4,2),
	us_vl_disco DECIMAL(4,2),
	us_vl_cpu DECIMAL(4,2),
	fk_id_funcionario INT,
	CONSTRAINT fk_id_funcionario FOREIGN KEY(fk_id_funcionario) REFERENCES tb_us_dados (id_cpf)
)

CREATE TABLE tb_ide_maquina(
	id_ide INT IDENTITY(1,1) PRIMARY KEY,
	us_nome_ide VARCHAR(45),
	us_dt_hr_start_IDE TIMESTAMP,
	us_dt_hr_end_IDE DATETIME,
	us_extensao_IDE VARCHAR(10),
	fk_id_maquina INT,
	CONSTRAINT fk_id_maquina FOREIGN KEY (fk_id_maquina) REFERENCES tb_us_maquina (id_maquina)
)

CREATE TABLE tb_processos_ide(
	id_processos INT IDENTITY(1,1) PRIMARY KEY,
	us_dt_hr_processo TIMESTAMP,
	us_ide_nome_processo VARCHAR(255),
	us_ide_ram DECIMAL(4,2),
	us_ide_cpu DECIMAL(4,2),
	us_ide_disco DECIMAL(4,2),
	fk_id_ide INT,
	CONSTRAINT fk_id_ide FOREIGN KEY(fk_id_ide) REFERENCES tb_ide_maquina (id_ide)
)

CREATE TABLE tb_log_hardware(
	id_log INT IDENTITY(1,1) PRIMARY KEY,
	us_dt_hr_log TIMESTAMP,
	us_log_hardware VARCHAR(255),
	us_total_ram DECIMAL(4,2),
	us_total_cpu DECIMAL(4,2),
	us_total_disco DECIMAL(4,2),
	fk_id_maq INT,
	CONSTRAINT fk_id_maq FOREIGN KEY (fk_id_maq) REFERENCES tb_us_maquina (id_maquina)
)