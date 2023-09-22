DROP TABLE IF EXISTS `User`;
CREATE TABLE User
(
    `_id`      int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(128) DEFAULT NULL,
    `account`  varchar(128) DEFAULT NULL,
    `password` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `Goods`;
CREATE TABLE `Goods`
(
    `_id`  int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(128) DEFAULT NULL,
    PRIMARY KEY (`_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

