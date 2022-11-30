package co.unicauca.parcial.mapper;

import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.model.Teacher;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class  CourseMapper {
    @Bean
    @Qualifier("courseMapperBean")
    public ModelMapper modelMapperCourse() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Teacher, TeacherDTO> teacherMap = mapper.emptyTypeMap(Teacher.class, TeacherDTO.class);
        teacherMap.addMappings(m->m.skip(TeacherDTO::setTeacherType)).implicitMappings();
        return mapper;
    }
}
