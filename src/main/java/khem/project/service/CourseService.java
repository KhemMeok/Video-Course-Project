package khem.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import khem.project.model.CourseModel;

public interface CourseService {
    CourseModel save(CourseModel entity);
    CourseModel getById(Long id);
    CourseModel Update(Long id,CourseModel source);
    void delete(Long id);
    List<CourseModel> findAll();
    Page<CourseModel> getCoursePage(Map<String,String> param);
}
