# Database Creation

Create Database Administration

# Table structure for table `classes`

CREATE TABLE `Classes` (
  `classId` int NOT NULL AUTO_INCREMENT,
  `section` int NOT NULL,
  `techerId` int NOT NULL,
  `subjectId` int NOT NULL,
  `time` varchar(44) NOT NULL,
  PRIMARY KEY (`classId`),
  KEY `subject_id` (`subjectId`),
  KEY `teacher_id` (`techerId`),
  CONSTRAINT `subject_id` FOREIGN KEY (`subjectId`) REFERENCES `Subjects` (`id`),
  CONSTRAINT `teacher_id` FOREIGN KEY (`techerId`) REFERENCES `Teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# Dumping data for table `classes`

INSERT INTO `Classes` (`classId`, `section`, `teacherId`, `subjectId`, `time`) VALUES
(1, 1, 1, 1, '9:00'),
(2, 3, 2, 2, '11:30');

# Table structure for table `students`

CREATE TABLE `Students` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(55) NOT NULL,
  `lastName` varchar(55) NOT NULL,
  `age` int DEFAULT NULL,
  `classId` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `class_id` (`classId`),
  CONSTRAINT `class_id` FOREIGN KEY (`classId`) REFERENCES `Classes` (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


# Dumping data for table `students`

INSERT INTO `students` (`id`, `firstName`, `lastName`, `age`, `classId`) VALUES
(1, 'Roshan', 'Patil', 21, 1),
(2, 'Ariket', 'Roy', 23, 2),
(4, 'Garima', 'Dani', 21, 1),
(5, 'Ttupti', 'Shah', 18, 2),
(6, 'Lalita', 'Shah', 24, 1),
(7, 'Tarush', 'Vani', 24, 2);

# Table structure for table `subjects`

CREATE TABLE `Subjects` (
  `id` int NOT NULL AUTO_INCREMENT,
  `subjectName` varchar(55) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `subjects` (`id`, `subjectName`) VALUES
(1, 'English'),
(2, 'Mathematics');

# Table structure for table `teachers`

CREATE TABLE `Teachers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tfirstName` varchar(55) NOT NULL,
  `tlastName` varchar(55) NOT NULL,
  `age` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# Dumping data for table `teachers`

INSERT INTO `teachers` (`id`, `tfirstName`, `tlastName`, `age`) VALUES
('1', 'Pushpa', 'Patil', '55'),
('2', 'P.N.', 'Marimutthu', '66');

