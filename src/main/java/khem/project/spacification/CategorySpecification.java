package khem.project.spacification;

import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import khem.project.Filter.CategoryFilter;
import khem.project.model.CategoryModel;
import khem.project.model.CategoryModel_;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategorySpecification implements Specification<CategoryModel> {
    
    private final CategoryFilter categoryFilter;

    @Override
    @Nullable
    public Predicate toPredicate(Root<CategoryModel> category, CriteriaQuery<?> query, CriteriaBuilder cb) {
         var list = new ArrayList<>();

         if(categoryFilter.getId() != null){
            Predicate filterCategoryId = category.get(CategoryModel_.ID).in(categoryFilter.getId());
            list.add(filterCategoryId);
         }
         if(categoryFilter.getName() != null){
            Predicate filterCategoryName = cb.like(category.get(CategoryModel_.NAME), "%" + categoryFilter.getName() + "%");
            list.add(filterCategoryName);
         }
         if(categoryFilter.getActive() != null){
            Predicate filterCategoryActive = cb.like(category.get(CategoryModel_.ACTIVE), "%" + categoryFilter.getActive() + "%");
            list.add(filterCategoryActive);
         }
         Predicate[] predicates = list.toArray(Predicate[]::new);

         return cb.and(predicates);
    }
    
}
