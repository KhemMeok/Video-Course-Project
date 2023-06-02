package khem.project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import khem.project.DTO.CourseDTO;
import khem.project.DTO.PageDTO;
import khem.project.Mapper.CourseMapper;
import khem.project.Mapper.PageMapper;
import khem.project.exception.APIException;
import khem.project.model.CourseModel;
import khem.project.service.CourseService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody CourseDTO entity) {
        return ResponseEntity.ok(courseMapper.toDTO(courseService.save(courseMapper.toCourse(entity))));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) throws APIException {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody CourseDTO entity) throws APIException {
        CourseModel courseModel = CourseMapper.INSTANCE.toCourse(entity);
        return ResponseEntity.ok().body(courseService.Update(id, courseModel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) throws APIException {
        courseService.delete(id);
        return ResponseEntity.ok().body("complete");
    }

    @GetMapping
    public ResponseEntity<?> getAll() throws APIException {
        List<CourseModel> list = courseService.findAll().stream().toList();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/page")
    public ResponseEntity<?> getCoursePage(@RequestParam Map<String, String> param) throws APIException {
        Page<CourseModel> page = courseService.getCoursePage(param);
        PageDTO pageDTO = PageMapper.INSTANCE.toDTO(page);
        pageDTO.setList(page.get().map(CourseMapper.INSTANCE::toDTO).toList());
        return ResponseEntity.ok().body(pageDTO);
    }

}
