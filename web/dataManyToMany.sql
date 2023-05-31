CREATE TABLE `many_to_many`.`user` (
  `idUser` INT NOT NULL AUTO_INCREMENT,
  `fullName` TEXT,
  `code` TEXT,
  `birthdate` DATE,
  `timeBuild` datetime,
  PRIMARY KEY (`idUser`));

CREATE TABLE `many_to_many`.`role` (
  `idRole` INT NOT NULL AUTO_INCREMENT,
  `role` TEXT,
  PRIMARY KEY (`idRole`));

create table midd(
	idUser int,
    idRole int,
	foreign key (idUser) references user(idUser),
	foreign key (idRole) references role(idRole),
    primary key (idUser, idRole)
);

DELETE FROM user
WHERE idUser = 1;

DELETE user, midd
FROM user
JOIN midd ON user.idUser = midd.idUser
WHERE user.idUser = 1;