package khem.project.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import khem.project.DTO.VideosDTO;
import khem.project.model.UsersModel;
import khem.project.model.VideoModel;
import khem.project.service.CourseService;
import khem.project.service.UsersService;

@Mapper(componentModel = "spring",uses = {CourseService.class,UsersService.class})
public interface VideosMapper {

    VideosMapper INSTANCE = Mappers.getMapper(VideosMapper.class);

   
    @Mappings({
        @Mapping(source = "createDate", target = "createDate"),
        @Mapping(source = "dateModified", target = "dateModified"),
         @Mapping(source = "dto.courseId",target = "course"),
        @Mapping(source = "dto.usersCreate",target = "usersCreate"),
        @Mapping(source = "dto.usersModified",target = "usersModified",qualifiedByName = "intToList"),
    })
    VideoModel toVideosModel(VideosDTO dto);
    @Mappings({
    @Mapping(source = "entity.course.id",target = "courseId"),
    @Mapping(source = "entity.usersCreate.id",target = "usersCreate"),
    @Mapping(source = "entity.usersModified",target = "usersModified",qualifiedByName = "listToInt"),
    @Mapping(source = "entity.createDate", target = "createDate"),
    @Mapping(source = "entity.dateModified", target = "dateModified"),
    })
    VideosDTO toVIdeoDTO(VideoModel entity);
    
    default Date stringToDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @Named("intToList")
    default List<UsersModel> intToList(Integer value) {
        // Convert the Integer value to a List<UsersModel> object
        // and return it
        List<UsersModel> userList = new ArrayList<>();
        // add logic here to convert the Integer value to a List<UsersModel> object
        return userList;
    }
    @Named("listToInt")
    default Integer listToInt(List<UsersModel> list) {
        // Convert the list to an integer value based on your specific requirements.
        // For example, you might want to return the size of the list.
        return list.size();
    }
}
