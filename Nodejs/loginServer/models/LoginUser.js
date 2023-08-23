
const { Sequelize } = require('sequelize');

module.exports = class LoginUser extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            userid: {
                type: Sequelize.STRING(200),
                allowNull: false,
                primaryKey: true,
            },
            nick_name: {
                type: Sequelize.STRING(200),
                allowNull: true,
            },
            pwd: {
                type: Sequelize.STRING(200),
                allowNull: true,
            },
            email: {
                type: Sequelize.STRING(200),
                allowNull: true,
            },
            provider: {
                type: Sequelize.STRING(200),
                allowNull: true,
                defaultValue: 'local',
            },
            snsid: {
                type: Sequelize.STRING(200),
                allowNull: true,
            }
        }, {
            sequelize,
            timestamps: true,
            underscored: false,
            modelName: 'loginusers',
            tableName: 'LoginUser',
            paranoid: true,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });
    }
    static associate(db) { }
}