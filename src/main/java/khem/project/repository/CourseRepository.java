package khem.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import khem.project.model.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Long>, JpaSpecificationExecutor<CourseModel> {
    boolean existsByName(String name);

    List<CourseModel> findByIdIn(List<Long> ids);

    List<CourseModel> findByActiveTrue(); 
}
