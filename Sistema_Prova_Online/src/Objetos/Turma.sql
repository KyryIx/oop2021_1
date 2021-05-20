CREATE TABLE `test`.`turma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `fk_curso` INT NOT NULL,
   PRIMARY KEY (`id`));

INSERT INTO `turma` (`codigo`, `fk_curso`) VALUES (4516, 481);