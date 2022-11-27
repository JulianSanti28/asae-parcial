package co.unicauca.parcial.mapper;

import co.unicauca.parcial.dto.CourseDTO;
import co.unicauca.parcial.model.Course;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CourseMapper {
    @Bean
    @Qualifier("courseMapperBean")
    public ModelMapper modelMapperCourse() {
        ModelMapper mapper = new ModelMapper();
        //TypeMap<Course, CourseDTO> map = mapper.emptyTypeMap(Course.class,CourseDTO.class);

        return mapper;
    }
}
