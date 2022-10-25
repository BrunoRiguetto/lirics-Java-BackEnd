-- CreateTable
CREATE TABLE `artist` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,

    UNIQUE INDEX `id_UNIQUE`(`id`),
    UNIQUE INDEX `name_UNIQUE`(`name`),
    PRIMARY KEY (`id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- CreateTable
CREATE TABLE `coments` (
    `id` INTEGER NOT NULL,
    `coment` VARCHAR(250) NULL,
    `users_id` INTEGER NOT NULL,
    `music_letter_id` INTEGER NOT NULL,

    INDEX `fk_coments_music_letter1_idx`(`music_letter_id`),
    INDEX `fk_coments_users_idx`(`users_id`),
    PRIMARY KEY (`id`, `users_id`, `music_letter_id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- CreateTable
CREATE TABLE `favorites` (
    `users_id` INTEGER NOT NULL,
    `music_letter_id` INTEGER NOT NULL,

    INDEX `fk_users_has_music_letter_music_letter1_idx`(`music_letter_id`),
    INDEX `fk_users_has_music_letter_users1_idx`(`users_id`),
    PRIMARY KEY (`users_id`, `music_letter_id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- CreateTable
CREATE TABLE `genre` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `genre` VARCHAR(45) NULL,

    UNIQUE INDEX `id_UNIQUE`(`id`),
    UNIQUE INDEX `genre_UNIQUE`(`genre`),
    PRIMARY KEY (`id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- CreateTable
CREATE TABLE `music_letter` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `songwriter` VARCHAR(200) NULL,
    `music_letter` TEXT NULL,
    `video_link` VARCHAR(500) NULL,
    `users_id` INTEGER NOT NULL,
    `genre_id` INTEGER NOT NULL,
    `artist_id` INTEGER NOT NULL,

    UNIQUE INDEX `id_UNIQUE`(`id`),
    INDEX `fk_music_letter_artist1_idx`(`artist_id`),
    INDEX `fk_music_letter_genre1_idx`(`genre_id`),
    INDEX `fk_music_letter_users1_idx`(`users_id`),
    PRIMARY KEY (`id`, `users_id`, `genre_id`, `artist_id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- CreateTable
CREATE TABLE `users` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `cpf` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,

    UNIQUE INDEX `id_UNIQUE`(`id`),
    UNIQUE INDEX `cpf_UNIQUE`(`cpf`),
    UNIQUE INDEX `email_UNIQUE`(`email`),
    PRIMARY KEY (`id`)
) DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- AddForeignKey
ALTER TABLE `coments` ADD CONSTRAINT `fk_coments_music_letter1` FOREIGN KEY (`music_letter_id`) REFERENCES `music_letter`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `coments` ADD CONSTRAINT `fk_coments_users` FOREIGN KEY (`users_id`) REFERENCES `users`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `favorites` ADD CONSTRAINT `fk_users_has_music_letter_music_letter1` FOREIGN KEY (`music_letter_id`) REFERENCES `music_letter`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `favorites` ADD CONSTRAINT `fk_users_has_music_letter_users1` FOREIGN KEY (`users_id`) REFERENCES `users`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `music_letter` ADD CONSTRAINT `fk_music_letter_artist1` FOREIGN KEY (`artist_id`) REFERENCES `artist`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `music_letter` ADD CONSTRAINT `fk_music_letter_genre1` FOREIGN KEY (`genre_id`) REFERENCES `genre`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- AddForeignKey
ALTER TABLE `music_letter` ADD CONSTRAINT `fk_music_letter_users1` FOREIGN KEY (`users_id`) REFERENCES `users`(`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

