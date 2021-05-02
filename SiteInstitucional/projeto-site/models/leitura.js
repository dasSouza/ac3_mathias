'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Leitura = sequelize.define('Leitura',{	
		id_processos: {
			field: 'id_processos',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		us_dt_hr_start_IDE: {
			field: 'us_dt_hr_start_IDE',
			type: DataTypes.DATE,
			allowNull: false
		},
		us_dt_hr_end_IDE: {
			field: 'us_dt_hr_end_IDE',
			type: DataTypes.DATE,
			allowNull: false
		},
		us_ide_nome_processo: {
			field: 'us_ide_nome_processo',
			type: DataTypes.STRING,
			allowNull: false
		},
		us_ide_ram: {
			field: 'us_ide_ram',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		us_ide_cpu: {
			field: 'us_ide_cpu',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		us_ide_disco: {
			field: 'us_ide_disco',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		fk_id_maquina: {
			field: 'fk_id_maquina',
			type: DataTypes.INTEGER,
			allowNull: false,
			references: {
				model: 'tb_us_maquina',
				key: 'id_maquina'
			}
		}
	}, 
	{
		tableName: 'tb_processos_ide', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Leitura;
};

