package khem.project.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import khem.project.DTO.UserDTO;
import khem.project.model.UsersModel;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UsersModel toUser(UserDTO dto);

    UserDTO toUserDTO(UsersModel entity);
    
}
