	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/
// tabela usuario
module.exports = (sequelize, DataTypes) => {
    let Usuario = sequelize.define('Usuario',{
		id_cpf: {
			field: 'id_cpf',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: false
		},
		us_nome_funcionario: {
			field: 'us_nome_funcionario',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_cargo: {
			field: 'us_cargo',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_login: {
			field: 'us_login',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_senha: { 
			field: 'us_senha',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_equipe: {
			field: 'us_equipe',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_is_adm: { 
			field: 'us_is_adm',
			type: DataTypes.TINYINT,
			allowNull: false
		},
		fk_id_empresa: {
			field: 'fk_id_empresa',
			type: DataTypes.INTEGER,
			allowNull: false,
			references: {
				model: 'tb_empresa',
				key: 'id_comp'
			}
		},
	}, 
	{
		tableName: 'tb_us_dados', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Usuario;
};