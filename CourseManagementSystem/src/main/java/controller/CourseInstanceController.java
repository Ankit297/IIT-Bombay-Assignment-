package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.CourseInstance;
import service.CourseInstanceService;

import java.util.List;

@RestController
@RequestMapping("/api/instances")
public class CourseInstanceController {
    @Autowired
    private CourseInstanceService courseInstanceService;

    @PostMapping
    public ResponseEntity<CourseInstance> createInstance(@RequestBody CourseInstance instance) {
        return ResponseEntity.ok(courseInstanceService.createCourseInstance(instance));
    }

    @GetMapping("/{year}/{semester}")
    public List<CourseInstance> getInstancesByYearAndSemester(@PathVariable int year, @PathVariable int semester) {
        return courseInstanceService.getInstancesByYearAndSemester(year, semester);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseInstance> getInstance(@PathVariable Long id) {
        CourseInstance instance = courseInstanceService.getInstanceById(id);
        return instance != null ? ResponseEntity.ok(instance) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstance(@PathVariable Long id) {
        courseInstanceService.deleteInstance(id);
        return ResponseEntity.ok().build();
    }
}
