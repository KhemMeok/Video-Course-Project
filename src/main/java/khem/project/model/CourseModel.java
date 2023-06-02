package khem.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseModel {
    @Id
    @GeneratedValue(generator = "course_seq_generator")
    @SequenceGenerator(name = "course_seq_generator", initialValue = 1, sequenceName = "course_seq_generator",  allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "course_name")
    private  String name;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel category;

}
