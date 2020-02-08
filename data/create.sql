-- -----------------------------------------------------
-- Schema store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `store`;
CREATE SCHEMA `store` DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Table `store`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`admin` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`creds`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`creds` (
  `id` BIGINT NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `creds_admin_fk`
    FOREIGN KEY (`id`)
    REFERENCES `store`.`admin` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`developer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`developer` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`game` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `developer_id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  `price` DECIMAL(13,2) NULL,
  PRIMARY KEY (`id`),
  INDEX `game_developer_fk_idx` (`developer_id` ASC) VISIBLE,
  CONSTRAINT `game_developer_fk`
    FOREIGN KEY (`developer_id`)
    REFERENCES `store`.`developer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`category` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`genre` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`game_genre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`game_genre` (
  `game_id` BIGINT NOT NULL,
  `genre_id` BIGINT NOT NULL,
  PRIMARY KEY (`game_id`, `genre_id`),
  INDEX `gg_genre_fk_idx` (`genre_id` ASC) VISIBLE,
  CONSTRAINT `gg_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `store`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `gg_genre_fk`
    FOREIGN KEY (`genre_id`)
    REFERENCES `store`.`genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`game_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `store`.`game_category` (
  `game_id` BIGINT NOT NULL,
  `category_id` BIGINT NOT NULL,
  PRIMARY KEY (`game_id`, `category_id`),
  INDEX `gc_category_fk_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `gc_game_fk`
    FOREIGN KEY (`game_id`)
    REFERENCES `store`.`game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `gc_category_fk`
    FOREIGN KEY (`category_id`)
    REFERENCES `store`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;