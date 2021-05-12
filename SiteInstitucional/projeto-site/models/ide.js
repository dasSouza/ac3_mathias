'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/
// tabela ide
module.exports = (sequelize, DataTypes) => {
    let Ide = sequelize.define('Ide',{
		tb_us_maquina_id_maquina: {
			field: 'tb_us_maquina_id_maquina',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: false
		},
		tb_ide_maquina_id_ide: {
			field: 'tb_ide_maquina_id_ide',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: false
		},
	}, 
	{
		tableName: 'tb_us_ass_maquina', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});
    return Ide;
};