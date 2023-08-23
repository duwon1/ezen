const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

let sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;
db.Sequelize = Sequelize;

const Member = require(`./Member`);
const Board = require(`./Board`);
const Reply = require(`./Reply`);

db.Member = Member;
db.Board = Board;
db.Reply = Reply;

Member.init(sequelize);
Board.init(sequelize);
Reply.init(sequelize);
Member.associate(db);
Board.associate(db);
Reply.associate(db);

module.exports = db;
