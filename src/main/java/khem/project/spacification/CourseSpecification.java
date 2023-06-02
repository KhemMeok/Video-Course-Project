package khem.project.spacification;
import java.util.ArrayList;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import khem.project.Filter.CourseFilter;
import khem.project.model.CategoryModel;
import khem.project.model.CategoryModel_;
import khem.project.model.CourseModel;
import khem.project.model.CourseModel_;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class CourseSpecification implements Specification<CourseModel> {

    private final CourseFilter courseFilter;

    @Override
    @Nullable
    public Predicate toPredicate(Root<CourseModel> course, CriteriaQuery<?> query, CriteriaBuilder cb) {
        var list = new ArrayList<>();

         if(courseFilter.getId() != null){
            Predicate filterCategoryId = course.get(CourseModel_.ID).in(courseFilter.getId());
            list.add(filterCategoryId);
         }
         if(courseFilter.getName() != null){
            Predicate filterCategoryName = cb.like(course.get(CourseModel_.NAME), "%" + courseFilter.getName() + "%");
            list.add(filterCategoryName);
         }
         if(courseFilter.getActive() != null){
            Predicate filterCategoryActive = cb.like(course.get(CourseModel_.ACTIVE), "%" + courseFilter.getActive() + "%");
            list.add(filterCategoryActive);
         }
         if(courseFilter.getCategoryId() != null){
            var categoryQuery = query.from(CategoryModel.class);
            Predicate filterCategoryActive = cb.like(categoryQuery.get(CategoryModel_.ID), "%" + courseFilter.getCategoryId() + "%");
            list.add(filterCategoryActive);
         }
         Predicate[] predicates = list.toArray(Predicate[]::new);

         return cb.and(predicates);
    }
    
}
