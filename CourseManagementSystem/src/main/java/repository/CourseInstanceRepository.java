package repository;


import org.springframework.data.jpa.repository.JpaRepository;

import model.CourseInstance;

import java.util.List;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Integer> {
    List<CourseInstance> findByYearAndSemester(int year, int semester);
}
