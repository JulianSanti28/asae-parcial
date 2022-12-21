package co.unicauca.parcial.mapper;

import co.unicauca.parcial.dto.StudentDTO;
import co.unicauca.parcial.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentMapper {
    @Bean
    @Qualifier("studentModelMapper")
    public ModelMapper studentModelMapper() {
        ModelMapper mapper = new ModelMapper();
//        TypeMap<Student, StudentDTO> map = mapper.emptyTypeMap(Student.class, StudentDTO.class);
//        map.addMappings(m->m.skip(StudentDTO::setIdentificationNumber)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setIdentificationType)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setName)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setLastName)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setAddress)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setTelephones)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setEntryDate)).implicitMappings();

        return mapper;
    }

    @Bean
    @Qualifier("modelMapperStudentToStudentDto")
    public ModelMapper modelMapperStudentToStudentDto() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Student, StudentDTO> map = mapper.emptyTypeMap(Student.class, StudentDTO.class);
//        map.addMappings(m->m.skip(StudentDTO::setIdentificationNumber)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setIdentificationType)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setName)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setLastName)).implicitMappings();
        map.addMappings(m->m.skip(StudentDTO::setAddress)).implicitMappings();
        map.addMappings(m->m.skip(StudentDTO::setTelephones)).implicitMappings();
//        map.addMappings(m->m.skip(StudentDTO::setEntryDate)).implicitMappings();

        return mapper;
    }



}
