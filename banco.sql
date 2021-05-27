CREATE DATABASE banco1;

USE banco1;

CREATE TABLE tb_us_maquina ( 

id_maquina BIGINT NOT NULL auto_increment primary key,  

us_nome_maquina VARCHAR(100) NOT NULL, 

us_vl_ram_total FLOAT NULL, 

us_vl_disco_total FLOAT NULL, 

us_vl_cpu_total VARCHAR(50) NULL ); 

 

CREATE TABLE tb_processos_ide ( 

id_processos BIGINT NOT NULL auto_increment primary key, 

us_dt_hr_start_IDE DATETIME NULL, 

us_dt_hr_end_IDE DATETIME NULL, 

us_ide_nome_processo VARCHAR(255) NOT NULL, 

us_ide_ram FLOAT NOT NULL, 

us_ide_cpu FLOAT NOT NULL, 

us_ide_disco FLOAT NOT NULL );