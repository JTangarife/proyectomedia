Tabla base de datos proyecto

CREATE TABLE `tienda`.`new_table` (
  `idnew_table` INT NOT NULL,
 
 `Producto` VARCHAR(45) NULL,
  `Categoria` VARCHAR(45) NULL,
  
`Precio` INT(40) NULL,
  PRIMARY KEY (`idnew_table`));



datos de la tabla productos


INSERT INTO `tienda`.`productos` (`Producto`, `Categoria`, `Precio`) VALUES ('Doritos', 'Comestibles', '1200');
INSERT INTO `tienda`.`productos` (`Producto`, `Categoria`, `Precio`) VALUES ('Empanada', 'Comestibles', '600');
INSERT INTO `tienda`.`productos` (`Producto`, `Categoria`, `Precio`) VALUES ('Hamburguesa', 'Comestibles', '2000');
INSERT INTO `tienda`.`productos` (`Producto`, `Categoria`, `Precio`) VALUES ('Coca-Cola', 'Bebidas', '1500');


tabla usuario

CREATE TABLE `tienda`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Contrase�a` VARCHAR(45) NULL,
  `Correo` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`));


tabla contactenos

CREATE TABLE `tienda`.`contactenos` (
  `idcontactenos` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL,
  `Tel�fono` INT(15) NULL,
  `Direccion` VARCHAR(45) NULL,
  `Mensaje` VARCHAR(12000) NULL,
  PRIMARY KEY (`idcontactenos`));

 
datos de la tabla
INSERT INTO `tienda`.`contactenos` (`Nombre`, `Tel�fono`, `Direccion`, `Mensaje`) VALUES ('Oscare', '35454', 'cra53q42', 'Qu���� hayyyyyyy');
INSERT INTO `tienda`.`contactenos` (`Nombre`, `Tel�fono`, `Direccion`, `Mensaje`) VALUES ('Tanguita', '2423', 'cll244', 'Nadaaaaaaaaaaaaaa c:');
INSERT INTO `tienda`.`contactenos` (`Nombre`, `Tel�fono`, `Direccion`, `Mensaje`) VALUES ('Sisas', '2488000', 'cr999', 'jajajajaja, qu� moral');

