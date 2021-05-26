/* https://dev.mysql.com/doc/refman/8.0/en/json.html */
CREATE TABLE `test`.`questao` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  `peso` FLOAT NOT NULL,
  `descricao` VARCHAR(1000) NOT NULL,
  `respostas` JSON,
  `indiceRespostaCorreta` INT NOT NULL,
   PRIMARY KEY (`id`));

INSERT INTO `questao` (`codigo`, `valor`, `peso`, `descricao`, `respostas`, `indiceRespostaCorreta`) VALUES (1564, 1.0, 1.0, 'Qual o resultado da expressao 1 + 1?', '["10", "2", "0", "1", "Nenhumas das anteriores"]', 1 );
INSERT INTO `questao` (`codigo`, `valor`, `peso`, `descricao`, `respostas`, `indiceRespostaCorreta`) VALUES (1565, 1.5, 1.0, 'Qual a cor branca do cavalo de Napoleão?', '["Branco", "Preto", "Cinza", "Azul escuro", "Nenhumas das anteriores"]', 2 );