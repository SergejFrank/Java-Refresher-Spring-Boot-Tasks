CREATE DATABASE IF NOT EXISTS `test-java-refresher-task` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test-java-refresher-task`;


DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(20) NOT NULL,
  `message` varchar(255) NOT NULL,
  `status` enum('TODO','DONE','DELETED') NOT NULL,
  `created_on` datetime DEFAULT NULL,
  `finished_on` datetime DEFAULT NULL,
  `due_to` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `message` (`message`),
  ADD KEY `status` (`status`);


ALTER TABLE `task`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
