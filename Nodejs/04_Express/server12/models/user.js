
// node 가 sequelize 를 이용해서 mysql 에 테이블을 생성하거나 조작할 수 있는 "테이블모델" 을 만듭니다
const Sequelize = require('sequelize')

// 테이블 모델은 class 형식으로 정의함
// class 모델명 { }

// 테이블을 위한 클래스 제작시 Sequelize에서 제공되는 Model 을 Extends 하여 제작함
// class 모델명 extends Sequelize.Model { }

// 그리고, 그 클래스가 exports 되어서 index에서 require 해서 테이블을 생성함
// module.export = class 모델명 extends Sequelize.Model { }
// 모델이름 : 테이블 이름과 같아도되고 다를수도 있음 모델명은 node 에서 테이블을 제거하기위한 이름

/*
module.export = class aa extends Sequelize.Model {
  // 테이블 생성하고 초기화하는 함수
  static init(sequelize) { }
  // 테이블간 관계 설정 함수
  static associations(db) { }

}
*/

/*
module.export = class aa extends Sequelize.Model {
  static init(sequelize) {
    return super.init({

    }, {

    })
  }
  static associations(db) { }

}
*/

// 외보웨서 user를 require 하고, user.init(Sequelize) 이와 같이 호출될 예정
module.exports = class User extends Sequelize.Model {
  static init(sequelize) {
    return super.init({
      // 필드들이 정의 됨
      // 별도의 언급이 없으면, 기본키속성의 자동증가 숫자를 대상으로 하는 id 라는 필드가 자동생성됨
      name: {
        type: Sequelize.STRING(20),
        allowNull: false, // NULL 허용 여부
        unique: false // 중복 여부
      },
      age: {
        type: Sequelize.INTEGER.UNSIGNED,
        allowNull: false
      },
      married: {
        type: Sequelize.BOOLEAN,
        allowNull: true
      },
      comment: {
        type: Sequelize.TEXT,
        allowNull: true
      },
      created_at: {
        type: Sequelize.DATE,
        allowNull: true
      }
    }, {
      //테이블의 옵션들이 객체형식으로 정의됩니다
      sequelize, // init 함수의 매개변수에 전달된 sequelize
      timestamp: false, // 이 속성이 true 이면, createdAt, updatedAt 필드를 자동 생성합니다
      underscored: false, // 이속성이true이면createdAt, updatedAt필드의 이름이 created_at, updated_at 으로 바뀜
      modelName: 'user', // Sequelize 가사용할 모델명
      tableName: 'users', // mysql 데이터베이스에서 사용할 테이블 이름
      paranoid: false, // 이 멤버가 true 이면, deletedAt 필드가 생성됩니다
      charset: 'utf8mb4',
      collate: 'utf8mb4_general_ci'
    })
  }
  static associate(db) {
    db.User.hasMany(db.Comment, {sourceKey: 'id', foreignKey: 'commenter'})
  }

}
