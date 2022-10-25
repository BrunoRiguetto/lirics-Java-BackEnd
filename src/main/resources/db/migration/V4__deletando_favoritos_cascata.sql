-- DropForeignKey
ALTER TABLE `coments` DROP FOREIGN KEY `fk_coments_music_letter1`;

-- AddForeignKey
ALTER TABLE `coments` ADD CONSTRAINT `fk_coments_music_letter1` FOREIGN KEY (`music_letter_id`) REFERENCES `music_letter`(`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
