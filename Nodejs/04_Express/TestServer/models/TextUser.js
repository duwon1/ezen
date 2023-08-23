const Sequelize = require(`sequelize`);

module.exports = class TextUser extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            userid: {
                type: Sequelize.STRING(50),
                allowNull: false,
                primaryKey: true,
            },
            name: {
                type: Sequelize.STRING(10),
                allowNull: false,
            },
            pwd: {
                type: Sequelize.STRING(30),
                allowNull: false,
            }
        }, {
            sequelize,
            timestamps: false,
            modelName: 'TextUser',
            tableName: 'TextUser',
            paranoid: false,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci'
        })
    }
    static associate(db) { }
}