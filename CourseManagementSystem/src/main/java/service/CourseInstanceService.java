package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CourseInstance;
import repository.CourseInstanceRepository;

import java.util.List;

@Service
public class CourseInstanceService {
    @Autowired
    private CourseInstanceRepository courseInstanceRepository;

    public CourseInstance createCourseInstance(CourseInstance instance) {
        return courseInstanceRepository.save(instance);
    }

    public List<CourseInstance> getInstancesByYearAndSemester(int year, int semester) {
        return courseInstanceRepository.findByYearAndSemester(year, semester);
    }

    public CourseInstance getInstanceById(Long id) {
        return courseInstanceRepository.findById(id).orElse(null);
    }

    public void deleteInstance(Long id) {
        courseInstanceRepository.deleteById(id);
    }
}
