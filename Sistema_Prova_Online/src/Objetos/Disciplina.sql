CREATE TABLE `test`.`disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `codigo` INT NOT NULL,
  `nome` VARCHAR(128) NOT NULL,
  `ementa` VARCHAR(255),
   PRIMARY KEY (`id`));

INSERT INTO `disciplina` (`codigo`, `nome`, `ementa`) VALUES (15245, 'Projeto Orientado a Objetos', 'Técnicas de programação Orientada a objetos. Tecnologias orientadas a objetos.');
INSERT INTO `disciplina` (`codigo`, `nome`, `ementa`) VALUES (15328, 'Programação WEB', 'Programação de páginas WEB, aplicação de estilos e tratamento de informações enviadas por formulários.');