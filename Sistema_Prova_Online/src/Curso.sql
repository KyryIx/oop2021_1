CREATE TABLE `test`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `fk_grade` INT NOT NULL,
  `codigo` INT,
   PRIMARY KEY (`id`));