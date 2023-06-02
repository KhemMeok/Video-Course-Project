package khem.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import khem.project.model.CategoryModel;


public interface CategoryService {
    CategoryModel save(CategoryModel entity);
    CategoryModel getById(Long id);
    CategoryModel Update(Long id,CategoryModel source);
    void delete(Long id);
    List<CategoryModel> findAll();
    Page<CategoryModel> getCategoryPage(Map<String,String> param);
}
