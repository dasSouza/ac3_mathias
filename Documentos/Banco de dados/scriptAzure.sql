CREATE TABLE tb_empresa (
	id_comp BIGINT IDENTITY(1,1) PRIMARY KEY,
	kc_nome_comp VARCHAR(255) NOT NULL,
	kc_cep_comp CHAR(8) NOT NULL,
	kc_cnpj_comp CHAR(14) NOT NULL,
	kc_telefone_comp CHAR(13) NOT NULL,
	kc_email_comp VARCHAR(255)
)

CREATE TABLE tb_us_dados (
	id_cpf BIGINT PRIMARY KEY,
	us_nome_funcionario VARCHAR(255),
	us_cargo VARCHAR(255),
	us_login VARCHAR(50),
	us_senha VARCHAR(30),
	us_is_adm TINYINT,
	fk_id_empresa BIGINT,
	CONSTRAINT fk_id_empresa FOREIGN KEY (fk_id_empresa) REFERENCES tb_empresa (id_comp)
)

CREATE TABLE tb_us_maquina(
	id_maquina BIGINT IDENTITY(1,1) PRIMARY KEY,
	us_nome_maquina VARCHAR(255),
	us_vl_ram_total DECIMAL(4,2),
	us_vl_disco_total DECIMAL(6,2),
	us_vl_cpu_total VARCHAR(50),
	fk_id_funcionario BIGINT,
	CONSTRAINT fk_id_funcionario FOREIGN KEY(fk_id_funcionario) REFERENCES tb_us_dados (id_cpf)
)

CREATE TABLE tb_ide_maquina(
	id_ide BIGINT IDENTITY(1,1) PRIMARY KEY,
	us_nome_ide VARCHAR(255),
	fk_id_maquina BIGINT,
	CONSTRAINT fk_id_maquina FOREIGN KEY (fk_id_maquina) REFERENCES tb_us_maquina (id_maquina)
)

CREATE TABLE tb_processos_ide(
	id_processos BIGINT IDENTITY(1,1) PRIMARY KEY,
	us_dt_hr_processo DATETIME,
	us_ide_nome_processo VARCHAR(255),
	us_extensao_IDE VARCHAR(50),
	us_ide_ram DECIMAL(4,2),
	us_ide_cpu DECIMAL(4,2),
	us_ide_disco DECIMAL(4,2),
	fk_id_ide BIGINT,
	CONSTRAINT fk_id_ide FOREIGN KEY(fk_id_ide) REFERENCES tb_ide_maquina (id_ide)
)

CREATE TABLE tb_log_hardware(
	id_log BIGINT IDENTITY(1,1) PRIMARY KEY,
	us_dt_hr_log DATETIME,
	us_log_hardware VARCHAR(255),
	us_total_ram DECIMAL(4,2),
	us_total_cpu DECIMAL(4,2),
	us_total_disco DECIMAL(4,2),
	fk_id_maq BIGINT,
	CONSTRAINT fk_id_maq FOREIGN KEY (fk_id_maq) REFERENCES tb_us_maquina (id_maquina)
)

insert into tb_empresa values ('valemobi', 0255505,10535290000121
,'1185476358','valemobi@vm.com.br')

select * from tb_empresa

insert into tb_us_dados values (49633264750, 'Samuel Lopes Almeida', 'estágiario','samuca','Teste123', '0', 1)

select * from tb_us_dados

insert into tb_us_maquina values ('vm007', 16.00, 10.00, 'i5-9400f', 49633264750)

select * from tb_us_maquina

insert into tb_ide_maquina values ('idea64', 1)

select * from tb_ide_maquina

insert into tb_processos_ide values (GETDATE(), 'idea64', '.java', 6.00, 22.17, 6.00, 1)

select * from tb_processos_ide

insert into tb_log_hardware values (GETDATE(), 'google chrome', 8.32, 48.20, 62.10, 1)

select * from tb_log_hardware
