package com.mycompany.myapp.demo;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.service.CourseService;
import com.mycompany.myapp.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    Logger log = LoggerFactory.getLogger(DemoService.class);

    private final CourseService courseService;
    private final StudentService studentService;

    public DemoService(CourseService courseService, StudentService studentService) {
        this.courseService = courseService;
        this.studentService = studentService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void demonstrate() {
        clean();
        log.info("Starting demo");
        demoPageable();
        System.exit(0);
    }

    private void clean() {
        courseService.findAll().forEach(course -> courseService.delete(course.getId()));
        studentService.findAll().forEach(student -> studentService.delete(student.getId()));
    }

    private void demoCRUD() {
        Course myCourse = courseService.save(
            new Course()
                .name("my course")
                .length(10)
        );
        log.info("Created is: {}", myCourse);

        log.info("From DB is: {}", courseService.findOne(myCourse.getId()));

        Course postUpdate = courseService.save(myCourse.length(15));
        log.info("Updated is: {}", postUpdate);

        courseService.delete(postUpdate.getId());
        log.info("Deleted");

        log.info("State is now: {}", courseService.findAll());
    }

    private void demoPageable() {
        courseService.save(
            new Course()
                .name("my course1")
                .length(10)
        );
        courseService.save(
            new Course()
                .name("my course2")
                .length(10)
        );
        courseService.save(
            new Course()
                .name("my course3")
                .length(10)
        );

        log.info("All courses: {}", courseService.findAll(Pageable.unpaged()));
        // notice the hibernate queries (limit, offset)
        log.info("Page 0: {}", courseService.findAll(PageRequest.of(0, 1)));
        log.info("Page 1: {}", courseService.findAll(PageRequest.of(1, 1)));
    }
}
