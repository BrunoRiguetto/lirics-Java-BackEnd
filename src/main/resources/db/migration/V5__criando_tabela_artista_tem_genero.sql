-- CreateTable
CREATE TABLE `artist_has_genre` (
    `artist_id` INTEGER NOT NULL,
    `genre_id` INTEGER NOT NULL,

    INDEX `fk_artist_has_genre_artist1_idx`(`artist_id`),
    INDEX `fk_artist_has_genre_genre1_idx`(`genre_id`),
    PRIMARY KEY (`artist_id`, `genre_id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- AddForeignKey
ALTER TABLE `artist_has_genre` ADD CONSTRAINT `fk_artist_has_genre_artist1` FOREIGN KEY (`artist_id`) REFERENCES `artist`(`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `artist_has_genre` ADD CONSTRAINT `fk_artist_has_genre_genre1` FOREIGN KEY (`genre_id`) REFERENCES `genre`(`id`) ON DELETE CASCADE ON UPDATE NO ACTION;
