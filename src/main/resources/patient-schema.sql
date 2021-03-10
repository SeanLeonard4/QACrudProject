DROP TABLE IF EXISTS `patient` CASCADE;
CREATE TABLE patient (
	`id` BIGINT AUTO_INCREMENT PRIMARY KEY,
	`age` INTEGER NOT NULL,
	`email` VARCHAR(255),
	`future_vaccine_date` VARCHAR(255),
	`name` VARCHAR(255), 
	`post_code` VARCHAR(255), 
	`vaccine` VARCHAR(255), 
	`vaccine_date` VARCHAR(255)
);


