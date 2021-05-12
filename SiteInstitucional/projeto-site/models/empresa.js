'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

// tabela empresa
module.exports = (sequelize, DataTypes) => {
    let Empresa = sequelize.define('Empresa',{
		id_comp: {
			field: 'id_comp',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		kc_nome_comp: {
			field: 'kc_nome_comp',
			type: DataTypes.STRING,
			allowNull: false
		},
		kc_cep_comp: {
			field: 'kc_cep_comp',
			type: DataTypes.STRING,
			allowNull: false
		},
		kc_cnpj_comp: {
			field: 'kc_cnpj_comp',
			type: DataTypes.STRING,
			allowNull: false
		},
		kc_telefone_comp: { 
			field: 'kc_telefone_comp',
			type: DataTypes.STRING,
			allowNull: false
		},
		kc_email_comp: { 
			field: 'kc_email_comp',
			type: DataTypes.STRING,
			allowNull: false
		},
	}, 
	{
		tableName: 'tb_empresa', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Empresa;
};
