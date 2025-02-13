package model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class CourseInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Course course;
    private int year;
    private int semester;
}