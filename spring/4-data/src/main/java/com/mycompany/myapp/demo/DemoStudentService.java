package com.mycompany.myapp.demo;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.Student;
import com.mycompany.myapp.service.CourseService;
import com.mycompany.myapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@SuppressWarnings("unused")
@Service
public class DemoStudentService {
    Logger log = LoggerFactory.getLogger(DemoStudentService.class);

    private final CourseService courseService;
    private final StudentService studentService;

    public DemoStudentService(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void demonstrate() {
        clean();
        log.info("Starting demo");
        demoLaziness();
        System.exit(0);
    }

    private void clean() {
        studentService.findAll().forEach(student -> studentService.delete(student.getId()));
        courseService.findAll().forEach(course -> courseService.delete(course.getId()));
    }

    private void demoLaziness() {
        Long advJavaId = courseService.save(new Course().name("advJava").length(5)).getId();
        Course advJava = courseService.findOne(advJavaId).get();

        log.info("Course from db is: {}", advJava);
        Student student = new Student().name("Bla").age(21).addCourses(advJava);
    }
}
