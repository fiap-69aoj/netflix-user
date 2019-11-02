INSERT INTO `user` (`name`, `email`, `phone`, `password`) VALUES ('flavio', 'flavio@fiap.com', '11999999999', '$2y$12$5ksm2T4qeqZJfbvlXcqkY.dhvfpREdiPtulnkkuArzdjUi9miI4eu');
INSERT INTO `user` (`name`, `email`, `phone`, `password`) VALUES ('ewerton', 'ewerton@fiap.com', '119888888', '$2y$12$LxRTGNNE1QcRqaPAgUSDiuVOmPt.KatsYIdC23EftinlvP1NS7DoW');
INSERT INTO `user` (`name`, `email`, `phone`, `password`) VALUES ('davi', 'davi@fiap.com', '119777777', '$2y$12$W2k1ILcuFhy1lmcT9eIHpOUkoqJB0pi24h1Ja8qnvJBHwxetYW5R.');
INSERT INTO `user` (`name`, `email`, `phone`, `password`) VALUES ('mateus', 'mateus@fiap.com', '11966666666', '$2y$12$JMH8bEeDwIIo/GN4PPxd4.iPuwdWdi.m0Dg.U9RJKCpeXPqiNcuVK');

INSERT INTO `authority` (`name`) VALUES ('ADMIN');
INSERT INTO `authority` (`name`) VALUES ('USER');

INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (1, 1);
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (2, 1);
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (3, 1);
INSERT INTO `users_authorities` (`user_id`, `authority_id`) VALUES (4, 1);