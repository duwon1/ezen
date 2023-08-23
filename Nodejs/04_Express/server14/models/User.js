
const { Sequelize } = require('sequelize');

module.exports = class User extends Sequelize.Model {
    static init(sequelize) {
        return super.init({
            email: {
                type: Sequelize.STRING(200),
                allowNull: true,
                unique: true // 널값끼리는 고유값 적용을 하지않음
            },
            nick: {
                type: Sequelize.STRING(200),
                allowNull: true,
            },
            password: {
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
            },
        }, {
            sequelize,
            timestamps: true,
            underscored: false,
            modelName: 'User',
            tableName: 'users',
            paranoid: true,
            charset: 'utf8mb4',
            collate: 'utf8mb4_general_ci',
        });
    }
    static associate(db) {
        db.User.hasMany(db.Post)
        // hasMany 와 belongsTo 사이에 targetkey, sourcekey, foreignkey 들을 지정하지 않으면 hasMany 의 주인공테이블(User)의 기본키가
        // belongsTO의 주인공테이블 (post) 의 외래키로 들어갑니다. 이때 필드명은 user테이블의 id 라는 뜻으로 Userid 가 됩니다
        db.User.belongsToMany(db.User, {
            foreignKey: 'followingId',
            as: 'Followers',
            through: 'Follow'
        })
        db.User.belongsToMany(db.User, {
            foreignKey: 'followerId',
            as: 'Followings',
            through: 'Follow'
        })
        // 테이블 이름 : Follow
        // 필드명 : followingId, followerId
        // USer 테이블로 부터 Follow 테이블에 접근할때는 Followers 와 Followings 로 접근합니다
    }
}