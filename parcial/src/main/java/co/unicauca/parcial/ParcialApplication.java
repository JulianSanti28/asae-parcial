package co.unicauca.parcial;

import co.unicauca.parcial.dao.IStudentRepository;
import co.unicauca.parcial.dao.ISubjectRepository;
import co.unicauca.parcial.model.Student;
import co.unicauca.parcial.model.Subject;
import co.unicauca.parcial.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class ParcialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParcialApplication.class, args);
	}

	@Autowired
	private IStudentRepository iStudentRepository;

	@Autowired
	private ISubjectRepository iSubjectRepository;

	@Override
	public void run(String... args) throws Exception {
		ArrayList<String> studentList = new ArrayList<>();
		studentList.add("10461876666");
		studentList.add("10461876667");
		studentList.add("10461876668");
		Set<Student> studentSet = iStudentRepository.findAllByIdentificationNumberIn(studentList);

		studentSet.forEach(System.out::println);

		Set<Subject> subjectSet = iSubjectRepository.findAllByNameContainingIgnoreCaseOrderByNameAsc("cal");

		subjectSet.forEach(System.out::println);
	}
}
