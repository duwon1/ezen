const Sequelize = require(`sequelize`);

module.exports = class Member extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            userid: {
                type: Sequelize.STRING(30),
                allowNull: false,
                primaryKey: true,
                unique: true,
            }, // 특정 필드에 키본키를 설정하면 자동으로 생성되는 id(일련번호) 필드는 생성되지 않습니다.
            pwd: {
                type: Sequelize.STRING(30),
                allowNull: false,
            },
            name: {
                type: Sequelize.STRING(30),
                allowNull: false,
            },
            phone: {
                type: Sequelize.STRING(20),
                allowNull: false,
            },
            email: {
                type: Sequelize.STRING(50),
                allowNull: false,
            },
            created_at: {
                type: Sequelize.DATE,
                allowNull: false,
                defaultValue: Sequelize.fn('NOW'),
            },
        },
        {
            sequelize,
            timestamps: false,
            modelName: `Member`,
            tableName: `members`,
            paranoid: false,
            charset: `utf8mb4`,
            collate: `utf8mb4_general_ci`,
        });
    };
    static associate(db) {
        db.Member.hasMany(db.Board, {
            sourceKey: `userid`,
            foreignKey: `writer`,
            onDelete: `cascade`, // hasMany 입장에서만 onDelete와 onUpdate를 설정할 수 있습니다. userid는 수정할 일이 없기 때문에 onUpdate는 설정하지 않습니다.
        });
        db.Member.hasMany(db.Reply, {
            sourceKey: `userid`,
            foreignKey: `writer`,
            onDelete: `cascade`,
        });
    };
};