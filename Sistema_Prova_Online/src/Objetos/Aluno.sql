CREATE TABLE `test`.`aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `nome` VARCHAR(64) NOT NULL,
  `sobrenome` VARCHAR(128) NOT NULL,
  `idade` INT NOT NULL,
  `fk_disciplina` INT,
  `fk_turma` INT,
   PRIMARY KEY (`id`));

INSERT INTO `aluno` (`codigo`, `nome`, `sobrenome`, `idade`, `fk_disciplina`, `fk_turma`) VALUES (1668730, 'Paulo', 'Rodrigues', 18, 15245, 4516);
INSERT INTO `aluno` (`codigo`, `nome`, `sobrenome`, `idade`, `fk_disciplina`, `fk_turma`) VALUES (1668740, 'Lucas', 'Fernandes', 31, 15245, 4516);
INSERT INTO `aluno` (`codigo`, `nome`, `sobrenome`, `idade`, `fk_disciplina`, `fk_turma`) VALUES (1685740, 'Maria', 'Neide',     45, 15245, 4516);