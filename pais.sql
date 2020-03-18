create database usjt1;

CREATE TABLE IF NOT EXISTS `usjt1`.`pais` (
  `idPais` INT NOT NULL AUTO_INCREMENT,
  `nomePais` VARCHAR(45) NOT NULL,
  `populacaoPais` DOUBLE NOT NULL,
  `areaPais` DOUBLE NOT NULL,
  PRIMARY KEY (`idPais`))
ENGINE = InnoDB;

USE `usjt1` ;

insert into pais (nomePais, populacaoPais, areaPais) values ('Brasil', 209300000, 8515767.049), ('China', 1379302771, 9596961),
('Estados Unidos da América', 325719178, 9371175), ('Italia', 60665551, 301338), ('Espanha', 46524943, 504030);

select * from pais;