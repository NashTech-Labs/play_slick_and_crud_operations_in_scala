# --- !Ups
CREATE TABLE `user_profile` (
   `id`            BIGINT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `first_name`    VARCHAR(254)   NOT NULL,
   `last_name`     VARCHAR(254)   NOT NULL,
   `email`         VARCHAR(254)   NOT NULL,
   `department`    VARCHAR(254)   NOT NULL,
   `created`       DATETIME       NOT NULL,
   `status`        BOOLEAN        NOT NULL DEFAULT 1
);

CREATE TABLE `events` (
    `id`         BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `profile_id` BIGINT       NOT NULL,
    `event_type` VARCHAR(254) NOT NULL,
    `invoked_at` TIMESTAMP    NOT NULL,
    FOREIGN KEY (`profile_id`) REFERENCES user_profile(id)
);



insert into user_profile values (1, 'test', 'test', 'test@example.com', 'address1', 'address2', 'city', 'state', '12345', '12/12/1998', 'female', false, current_timestamp, 0);

# ---- !Downs
DROP TABLE `p3_user_info`;
DROP TABLE `events`;
DROP TABLE `receipts`;
DROP TABLE `user_support`;
DROP TABLE `reward_entries`;
DROP TABLE `user_profile`;