CREATE TABLE `test`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT,
  `nome` VARCHAR(255) NOT NULL,
  `fk_grade` INT NOT NULL,
   PRIMARY KEY (`id`));

INSERT INTO `curso` (`codigo`, `nome`, `fk_disciplinas`) VALUES (481, 'Sistema de Informação', 8548);