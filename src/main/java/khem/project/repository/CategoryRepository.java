package khem.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import khem.project.model.CategoryModel;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel,Long>, JpaSpecificationExecutor<CategoryModel>{
    boolean existsByName(String name);

    List<CategoryModel> findByIdIn(List<Long> ids);

    List<CategoryModel> findByActiveTrue(); 
}
