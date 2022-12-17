package co.unicauca.parcial.mapper;

import co.unicauca.parcial.dto.TeacherDTO;
import co.unicauca.parcial.model.Teacher;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherMapper {
    @Bean
    @Qualifier("teacherMapperBean")
    public ModelMapper modelMapperTeacher() {
        ModelMapper mapper = new ModelMapper();

        return mapper;
    }
}
