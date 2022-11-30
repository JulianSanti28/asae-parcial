package co.unicauca.parcial.dto.course;

public class CourseNotFoundException extends Exception{

    public CourseNotFoundException() {
    }

    public CourseNotFoundException(String message) {
        super(message);
    }
}
