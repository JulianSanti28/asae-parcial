INSERT INTO `subject`(`subjectId`, `name`) VALUES ('1','Calculo 1')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('2','POO')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('3','Vibraciones y ondas')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('4','INVOPER')

INSERT INTO `course`(`courseId`, `name`, `period`, `id_subject`) VALUES ('1A','AA','2022','2')

INSERT INTO `teacher`(`idPerson`, `identificationNumber`, `identificationType`, `lastName`, `name`, `salary`, `teacherType`, `university`) VALUES ('1','1061822349','CC','Collazos','David','32445','nose','Cauca')
INSERT INTO `subjectteacher` (`subjectId`, `teacherId`) VALUES ('2', '1');

INSERT INTO `student` (`idPerson`, `identificationNumber`, `identificationType`, `lastName`, `name`, `email`, `entryDate`) VALUES ('1', '10461876666', 'CC', 'perez', 'pepito', 'pepitop@mail.com', '2022-12-20');
INSERT INTO `address`(`studentId`, `ubication`) VALUES ('1','una calle cualquiera')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('1','81223456','phone','1')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('2','81223457','phone','1')

INSERT INTO `student` (`idPerson`, `identificationNumber`, `identificationType`, `lastName`, `name`, `email`, `entryDate`) VALUES ('2', '10461876667', 'CC', 'juanela', 'juanita', 'juanitaj@mail.com', '2022-12-20');
INSERT INTO `address`(`studentId`, `ubication`) VALUES ('2','una calle cualquiera')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('4','81223456','phone','2')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('5','81223457','phone','2')

INSERT INTO `student` (`idPerson`, `identificationNumber`, `identificationType`, `lastName`, `name`, `email`, `entryDate`) VALUES ('3', '10461876668', 'CC', 'carro', 'carlitos', 'carlitosc@mail.com', '2022-12-20');
INSERT INTO `address`(`studentId`, `ubication`) VALUES ('3','una calle cualquiera')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('6','81223456','phone','3')
INSERT INTO `telephone`(`telephoneId`, `number`, `type`, `studentId`) VALUES ('7','81223457','phone','3')