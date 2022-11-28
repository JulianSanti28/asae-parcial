INSERT INTO `subject`(`subjectId`, `name`) VALUES ('1','Calculo 1')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('2','POO')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('3','Vibraciones y ondas')
INSERT INTO `subject`(`subjectId`, `name`) VALUES ('4','INVOPER')

INSERT INTO `course`(`courseId`, `name`, `period`, `id_subject`) VALUES ('1A','AA','2022','2')

INSERT INTO `teacher`(`idPerson`, `identificationNumber`, `identificationType`, `lastName`, `name`, `salary`, `teacherType`, `university`) VALUES ('1','1061822349','CC','Collazos','David','32445','nose','Cauca')
INSERT INTO `subjectteacher` (`subjectId`, `teacherId`) VALUES ('2', '1');
