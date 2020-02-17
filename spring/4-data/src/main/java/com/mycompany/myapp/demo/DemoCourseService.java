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

@SuppressWarnings("unused")
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
        demoNoTransaction();
        System.exit(0);
    }

    private void clean() {
        courseService.findAll().forEach(course -> courseService.delete(course.getId()));
    }

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
        log.info("Page 1: {}", courseService.findAll(PageRequest.of(0, 1)));
        log.info("Page 2: {}", courseService.findAll(PageRequest.of(1, 1)));
    }

    private void demoCustomizations() {
        String name = "my course";
        courseService.save(
                new Course()
                        .name(name)
                        .length(10)
        );
        courseService.save(
                new Course()
                        .name("other")
                        .length(10)
        );

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

    //@Transactional
    public void demoNoTransaction() {
        demoLaziness();
    }

    private void demoTransaction() {
        courseService.withTransaction(this::demoLaziness);
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    private void demoLaziness() {
        Long advJavaId = courseService.save(new Course().name("advJava").length(5)).getId();
        Course advJava = courseService.findOne(advJavaId).get();

        log.info("Course from db is: {}", advJava);
        log.info("Students in course are: " + advJava.getStudents());
    }
}
