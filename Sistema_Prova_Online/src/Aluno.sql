CREATE TABLE `test`.`aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `nome` VARCHAR(64) NOT NULL,
  `sobrenome` VARCHAR(128) NOT NULL,
  `idade` INT NOT NULL,
  `fk_disciplina` INT,
  `fk_turma` INT,
   PRIMARY KEY (`id`));