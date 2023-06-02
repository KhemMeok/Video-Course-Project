package khem.project.service.serviceIMPL;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import khem.project.Filter.CategoryFilter;
import khem.project.exception.APIException;
import khem.project.model.CategoryModel;
import khem.project.repository.CategoryRepository;
import khem.project.service.CategoryService;
import khem.project.spacification.CategorySpecification;
import khem.project.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceIMPL implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryModel save(CategoryModel entity) {
        return categoryRepository.save(entity);
    }

    @Override
    public CategoryModel getById(Long id){
        return categoryRepository.findById(id).orElseThrow(
                 () -> new APIException(HttpStatus.NOT_FOUND, String.format("category not found for id=%d", id)));
    }

    @Override
    public CategoryModel Update(Long id, CategoryModel source) {
        CategoryModel target = getById(id);
        BeanUtils.copyProperties(source, target, "id");
        return categoryRepository.save(target);
    }

    @Override
    public void delete(Long id) {
        CategoryModel categoryModel = getById(id);
        categoryModel.setActive(false);
        categoryRepository.save(categoryModel);
        log.info("category with id=%d is deleted".formatted(id));
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findByActiveTrue();
    }

    @Override
    public Page<CategoryModel> getCategoryPage(Map<String, String> param) {
        Pageable pageable = PageUtil.getPageable(param);
        CategoryFilter categoryFilter = new CategoryFilter();
        if(param.containsKey("id")){
            categoryFilter.setId(Long.valueOf(MapUtils.getInteger(param, "id")));

        }
        if(param.containsKey("name")){
            categoryFilter.setName(MapUtils.getString(param, "name"));
        }
        CategorySpecification categorySpacification = new CategorySpecification(categoryFilter);
        Page<CategoryModel> page = categoryRepository.findAll(categorySpacification, pageable);
        page.getNumberOfElements();
        return page;

    }

   


  

   

   

   
    
}
