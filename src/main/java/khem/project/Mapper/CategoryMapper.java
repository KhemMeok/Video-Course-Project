package khem.project.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import khem.project.DTO.CategoryDTO;
import khem.project.model.CategoryModel;
@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryModel toEntity(CategoryDTO entity);
    CategoryDTO toDTO(CategoryModel dto);

}
