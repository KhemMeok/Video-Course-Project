package khem.project.service.serviceIMPL;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import khem.project.Filter.CourseFilter;
import khem.project.Mapper.CourseMapper;
import khem.project.exception.APIException;
import khem.project.model.CourseModel;
import khem.project.repository.CourseRepository;
import khem.project.service.CourseService;
import khem.project.spacification.CourseSpecification;
import khem.project.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class CourseServiceIMPL implements CourseService{

    private final CourseRepository courseRepository;

    @Override
    public CourseModel save(CourseModel entity) {
        return courseRepository.save(entity);
    }

    @Override
    public CourseModel getById(Long id) {
        return courseRepository.findById(id).orElseThrow(
            () -> new APIException(HttpStatus.NOT_FOUND, String.format("Course not found for id=%d", id)));
    }

    @Override
    public CourseModel Update(Long id, CourseModel source) {
        var target = CourseMapper.INSTANCE.toDTO(getById(id));
        var t2 = CourseMapper.INSTANCE.toCourse(target);
        BeanUtils.copyProperties(source, t2, "id");
        return courseRepository.save(t2);
    }

    @Override
    public void delete(Long id) {
        CourseModel courseModel = getById(id);
        courseModel.setActive(false);
        courseRepository.save(courseModel);
        log.info("category with id=%d is deleted".formatted(id));
    }

    @Override
    public List<CourseModel> findAll() {
        return courseRepository.findByActiveTrue();
    }

    @Override
    public Page<CourseModel> getCoursePage(Map<String, String> param) {
        Pageable pageable = PageUtil.getPageable(param);
        CourseFilter courseFilter = new CourseFilter();
        if(param.containsKey("id")){
            courseFilter.setId(Long.valueOf(MapUtils.getInteger(param, "id")));

        }
        if(param.containsKey("name")){
            courseFilter.setName(MapUtils.getString(param, "name"));
        }
        CourseSpecification courseSpacification = new CourseSpecification(courseFilter);
        Page<CourseModel> page = courseRepository.findAll(courseSpacification, pageable);
        page.getNumberOfElements();
        return page;
    }
    
}
