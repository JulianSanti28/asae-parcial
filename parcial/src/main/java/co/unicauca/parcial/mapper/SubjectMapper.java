package co.unicauca.parcial.mapper;

import co.unicauca.parcial.dto.SubjectDTO;
import co.unicauca.parcial.model.Subject;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubjectMapper {

    @Bean
    @Qualifier("subjectMapperBean")
    public ModelMapper modelMapperSubject(){
        ModelMapper mapper = new ModelMapper();
//        TypeMap<Subject, SubjectDTO> map = mapper.emptyTypeMap(Subject.class,SubjectDTO.class);
//        map.addMappings(m->m.skip(SubjectDTO::setCourses)).implicitMappings();
//        map.addMappings(m->m.skip(SubjectDTO::setTeachers)).implicitMappings();
        return mapper;
    }
}
