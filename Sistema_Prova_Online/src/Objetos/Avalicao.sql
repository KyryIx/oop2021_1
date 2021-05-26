/* https://dev.mysql.com/doc/refman/8.0/en/json.html */
CREATE TABLE `test`.`avaliacao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `fk_aluno` INT NOT NULL,
  `fk_turma` INT NOT NULL,
  `fk_disciplina` INT NOT NULL,
  `fk_professor` INT NOT NULL,
  `fk_curso` INT NOT NULL,
  `dataAvaliacao` DATE NOT NULL,
  `fk_questoes` JSON,
  `respostas` JSON,
  `fk_nota` INT NOT NULL,
   PRIMARY KEY (`id`));

INSERT INTO `avaliacao` (`codigo`,`fk_aluno`,`fk_turma`,`fk_disciplina`,`fk_professor`,`fk_curso`,`dataAvaliacao`,`fk_questoes`,`respostas`,`fk_nota`) VALUES (876167, 1668740, 4516, 15245, 100100789, 481, '2021-05-14', '[1564,1565]', '[0,0]', 46164 );