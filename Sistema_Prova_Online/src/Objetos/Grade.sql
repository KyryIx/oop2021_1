/* https://dev.mysql.com/doc/refman/8.0/en/json.html */
CREATE TABLE `test`.`grade` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `fk_disciplinas` JSON,
   PRIMARY KEY (`id`));

INSERT INTO `grade` (`codigo`, `fk_disciplinas`) VALUES (8531, '[[15245,15328]]');
INSERT INTO `grade` (`codigo`, `fk_disciplinas`) VALUES (8548, '[[15245],[15328]]');