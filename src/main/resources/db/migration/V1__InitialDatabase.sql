CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(256) NOT NULL,
  `password` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `authorities` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `fk_authorities_authority1_idx` (`authority_id`),
  CONSTRAINT `fk_authorities_authority1` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_authorities_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `user` (`username`, `password`) VALUES ('flavio', 'f76405ac130dac085b2a6249073b213b');
INSERT INTO `user` (`username`, `password`) VALUES ('ewerton', '38598fe84388058562483fc1926543dd');
INSERT INTO `user` (`username`, `password`) VALUES ('davi', '4aa606997465fd6fc4e825ff8695fcdf');
INSERT INTO `user` (`username`, `password`) VALUES ('mateus', 'e42b6a82864b7060c447ecebd62518a3');

INSERT INTO `authority` (`name`) VALUE ('ADMIN');
INSERT INTO `authority` (`name`) VALUE ('USER');

INSERT INTO `authorities` (`user_id`, `authority_id`) VALUE (1, 1);
INSERT INTO `authorities` (`user_id`, `authority_id`) VALUE (2, 1);
INSERT INTO `authorities` (`user_id`, `authority_id`) VALUE (3, 1);
INSERT INTO `authorities` (`user_id`, `authority_id`) VALUE (4, 1);