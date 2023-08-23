
const { Sequelize } = require('sequelize');

module.exports = class Post extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            // 기본키적용된 id, writer, 피드내용, 이미지
            content: {
                type: Sequelize.STRING(1000),
                allowNull: false,
            }, img: {
                type: Sequelize.STRING(200),
                allowNull: true,
            }
        }, {
            sequelize,
            timestamps: true,
            funderscired: false,
            modelName: 'Post',
            tableName: 'posts',
            paranoid: true,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });
    }
    static associate(db) {
        db.Post.belongsTo(db.User);
        db.Post.belongsToMany(db.Hashtag, { through: 'PostHashtag' })
        // posts 테이블과 hashtags 테이블의 N:N 관계를 위한 postHashtag 테이블을 새롭게 생성합니다. posts(1) : PostHashtag(N), 
        // PostHashtag(N) : Hashtag(1) 두 관계를 사용하여 N:N 관계를 설정합니다
    }
}