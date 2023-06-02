package khem.project.Filter;

import khem.project.model.CategoryModel;
import lombok.Data;

@Data
public class CourseFilter {
    private Long id;
    private String name;
    private Boolean active;
    private CategoryModel categoryId;
}
