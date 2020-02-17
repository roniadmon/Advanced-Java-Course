package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Course;
import com.mycompany.myapp.domain.Course_;
import com.mycompany.myapp.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Course}.
 */
@Service
@Transactional
public class CourseService {

    private final Logger log = LoggerFactory.getLogger(CourseService.class);

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {
        log.debug("Request to save Course : {}", course);
        return courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public Page<Course> findAll(Pageable pageable) {
        log.debug("Request to get all Courses");
        return courseRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<Course> findAll() {
        log.debug("Request to get all Courses");
        return courseRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Course> findOne(Long id) {
        log.debug("Request to get Course : {}", id);
        return courseRepository.findById(id);
    }

    public void delete(Long id) {
        log.debug("Request to delete Course : {}", id);
        courseRepository.deleteById(id);
    }

    public Optional<Course> findOneWhereNameIsBySpecification(String name) {
        Specification<Course> spec = createSpecification(name);
        return courseRepository.findOne(spec);
    }

    private Specification<Course> createSpecification(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get(Course_.name),
                        name
                );
    }

    public Optional<Course> findOneWhereNameIsByQuery(String name) {
        return courseRepository.findByQuery(name);
    }

    public Optional<Course> findOneWhereNameIsByMethod(String name) {
        return courseRepository.findByName(name);
    }

    @Transactional
    public void withTransaction(Runnable runnable) {
        runnable.run();
    }
}
