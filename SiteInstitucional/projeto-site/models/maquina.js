'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Maquina = sequelize.define('Maquina',{	
		id_maquina: {
			field: 'id_maquina',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		us_nome_maquina: {
			field: 'us_nome_maquina',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_vl_ram_total: {
			field: 'us_vl_ram_total',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		us_vl_disco_total: {
			field: 'us_vl_disco_total',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		us_vl_cpu_total: {
			field: 'us_vl_cpu_total',
			type: DataTypes.STRING,
			allowNull: false
		},
		fk_id_funcionario: {
			field: 'fk_id_funcionario',
			type: DataTypes.INTEGER,
			allowNull: false,
			references: {
				model: 'tb_us_dados',
				key: 'id_cpf'
			}
		}
	}, 
	{
		tableName: 'tb_us_maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Maquina;
};

