package com.mycompany.myapp.demo;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"unused", "OptionalGetWithoutIsPresent"})
@Service
public class DemoCourseService {
    Logger log = LoggerFactory.getLogger(DemoCourseService.class);

    private final CourseService courseService;

    public DemoCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void demonstrate() {
        clean();
        log.info("Starting demo");
        demoCRUD();
        System.exit(0);
    }

    private void clean() {
        courseService.findAll().forEach(course -> courseService.delete(course.getId()));
    }

    private Long createCourseWithName(String name) {
        return courseService.save(new Course().name(name)).getId();
    }

    // Customizations

    private void demoCRUD() {
        Course original = new Course()
                .name("my course")
                .length(10);
        log.info("Original is: {}", original);

        Course myCourse = courseService.save(original);
        log.info("Created is: {}", myCourse);
        // are they the same?

        log.info("From DB is: {}", courseService.findOne(myCourse.getId()));

        Course postUpdate = courseService.save(myCourse.length(15));
        log.info("Updated is: {}", postUpdate);

        courseService.delete(postUpdate.getId());
        log.info("Deleted");

        log.info("State is now: {}", courseService.findAll());
    }

    private void demoPageable() {
        createCourseWithName("my course1");
        createCourseWithName("my course2");
        createCourseWithName("my course3");

        log.info("All courses: {}", courseService.findAll(Pageable.unpaged()));
        // notice the hibernate queries (limit, offset)
        log.info("Page 1: {}", courseService.findAll(PageRequest.of(0, 1)));
        log.info("Page 2: {}", courseService.findAll(PageRequest.of(1, 1)));
    }

    private void demoCustomizations() {
        String name = "my course";
        createCourseWithName(name);
        createCourseWithName("other");

        Optional<Course> bySpec = courseService.findOneWhereNameIsBySpecification(name);
        Optional<Course> byQuery = courseService.findOneWhereNameIsByQuery(name);
        Optional<Course> byMethod = courseService.findOneWhereNameIsByMethod(name);

        List<String> names = Stream.of(bySpec, byQuery, byMethod).map(Optional::get).map(Course::getName).collect(Collectors.toList());
        log.info("Names are: {}", names);
    }

    private void demoConstraints() {
        try {
            courseService.save(new Course());
        } catch (Exception e) {
            log.error("Exception 1", e);
        }

        try {
            courseService.save(new Course().name("a"));
        } catch (Exception e) {
            log.error("Exception 2", e);
        }
        // notice - these exceptions happen before a request is sent to the db, other exceptions may arise after that
    }

    // Transaction

    // what is a transaction?
    // when should you use it?

    // @Transactional API in spring
    //      annotation on method
    //      exceptions
    //      annotation on stack (@Transactional inside @Transactional)
    //          readonly
    //      @Transactional inside the same class

    //@Transactional
    public void demoNoTransaction() {
        lookAtCourse();
    }

    private void demoTransaction() {
        courseService.withTransaction(this::lookAtCourse);
    }

    private void lookAtCourse() {
        Long advJavaId = createCourseWithName("advJava");
        Course advJava = courseService.findOne(advJavaId).get();

        log.info("Course from db is: {}", advJava);
        log.info("Students in course are: " + advJava.getStudents());
    }

    private void modifyOutOfTransaction() {
        Course advJava = courseService.findOne(createCourseWithName("advJava")).get();
        addLength(advJava);

        log.info("Course from DB is {}", courseService.findOneWhereNameIsByMethod("advJava").get());
    }

    private void modifyInsideTransaction() {
        courseService.withTransaction(() -> {
            Course advJava = courseService.findOne(createCourseWithName("advJava")).get();
            addLength(advJava);
        });

        log.info("Course from DB is {}", courseService.findOneWhereNameIsByMethod("advJava").get());
    }

    private void addLength(Course advJava) {
        advJava.length(27);
    }
}
