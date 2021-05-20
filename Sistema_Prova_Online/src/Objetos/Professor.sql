CREATE TABLE `test`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `nome` VARCHAR(64) NOT NULL,
  `sobrenome` VARCHAR(128) NOT NULL,
  `idade` INT NOT NULL,
  `fk_disciplina` INT,
  `fk_turma` INT,
   PRIMARY KEY (`id`));

INSERT INTO `turma` (`codigo`, `fk_curso`) VALUES (100100789, 'Everton', 'Pereira', 41, 15245, 4516 );