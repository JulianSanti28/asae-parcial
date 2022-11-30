package co.unicauca.parcial.service;

import co.unicauca.parcial.dto.course.CourseDTO;
import co.unicauca.parcial.dto.course.CourseNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ICourseService {
    CourseDTO saveCourse(CourseDTO course);
    List<CourseDTO> findAllCourse();
    Optional<CourseDTO> getCourseById(String courseId) throws CourseNotFoundException;
    CourseDTO updateCourse(String courseId, CourseDTO course);
    boolean deleteCourse(String courseId);
}
