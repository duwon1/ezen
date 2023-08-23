
const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

let sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;
db.Sequelize = Sequelize;

const LoginUser = require('./loginUser');

db.User = LoginUser;

LoginUser.init(sequelize);

LoginUser.associate(db);


module.exports = db;
