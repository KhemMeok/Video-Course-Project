package khem.project.service;

import khem.project.DTO.UserDTO;
import khem.project.model.UsersModel;

public interface UsersService {
    UsersModel add(UserDTO entity);
    UsersModel getById(Long id);
}
