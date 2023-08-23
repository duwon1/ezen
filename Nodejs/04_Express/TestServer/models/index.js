const Sequelize = require('sequelize');
const env = process.env.NODE_ENV || 'development';
const config = require(__dirname + '/../config/config.json')[env];
const db = {};

let sequelize = new Sequelize(config.database, config.username, config.password, config);

db.sequelize = sequelize;
db.Sequelize = Sequelize;

const textUser = require(`./TextUser`);

db.TextUser = textUser;

textUser.init(sequelize);

textUser.associate(db);

module.exports = db;
