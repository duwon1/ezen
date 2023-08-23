// id(댓글번호-자동생성)
// boardnum(게시물번호 - Board 외래키)
// writer(댓글작성자 - Member 외래키)
// content(댓글 내용)
// created_at(작성 일시)
const Sequelize = require(`sequelize`);

module.exports = class Reply extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            content: {
                type: Sequelize.STRING(1000),
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
            modelName: `Reply`,
            tableName: `replys`,
            paranoid: false,
            charset: `utf8mb4`,
            collate: `utf8mb4_general_ci`,
        });
    };
    static associate(db) {
        db.Reply.belongsTo(db.Member, {
            targetKey: `userid`,
            foreignKey: `writer`,
        });
        db.Reply.belongsTo(db.Board, {
            targetKey: `id`,
            foreignKey: `boardnum`,
        });
    };
};