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
		us_dt_hr_processo: {
			field: 'us_dt_hr_processo',
			type: DataTypes.DATE,
			allowNull: false
		},
		us_extensao_IDE: {
			field: 'us_extensao_IDE',
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
		us_ide_total_processo: {
			field: 'us_ide_total_processo',
			type: DataTypes.DOUBLE,
			allowNull: false
		},
		fk_id_ide: {
			field: 'fk_id_ide',
			type: DataTypes.INTEGER,
			allowNull: false,
			references: {
				model: 'tb_ide_maquina',
				key: 'id_ide'
			}
		}
		// momento_grafico: {
		// 	type: DataTypes.VIRTUAL, // campo 'falso' (não existe na tabela). Deverá ser preenchido 'manualmente' no select
		// 	allowNull: true
		// }
	}, 
	{
		tableName: 'tb_processos_ide', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Leitura;
};


// 'use strict';

// /* 
// lista e explicação dos Datatypes:
// https://codewithhugo.com/sequelize-data-types-a-practical-guide/
// */

// module.exports = (sequelize, DataTypes) => {
//     let Leitura = sequelize.define('Leitura',{	
// 		idleitura: {
// 			field: 'idleitura',
// 			type: DataTypes.INTEGER,
// 			primaryKey: true,
// 			autoIncrement: true
// 		},	
// 		temperatura: {
// 			field: 'temperatura',
// 			type: DataTypes.REAL,
// 			allowNull: false
// 		},
// 		momento: {
// 			field: 'momento',
// 			type: DataTypes.DATE, // NÃO existe DATETIME. O tipo DATE aqui já tem data e hora
// 			allowNull: false
// 		},
// 		momento_grafico: {
// 			type: DataTypes.VIRTUAL, // campo 'falso' (não existe na tabela). Deverá ser preenchido 'manualmente' no select
// 			allowNull: true
// 		}
// 	}, 
// 	{
// 		tableName: 'leitura', 
// 		freezeTableName: true, 
// 		underscored: true,
// 		timestamps: false,
// 	});

//     return Leitura;
// };
