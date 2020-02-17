package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the Course entity.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    @Query("SELECT c FROM Course c WHERE c.name = :name")
    Optional<Course> findByQuery(@Param("name") String name);

    Optional<Course> findByName(String name);
}
