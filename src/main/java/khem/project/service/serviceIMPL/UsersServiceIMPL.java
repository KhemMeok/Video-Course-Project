package khem.project.service.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import khem.project.DTO.UserDTO;
import khem.project.Mapper.UserMapper;
import khem.project.exception.APIException;
import khem.project.model.UsersModel;
import khem.project.repository.UsersRepository;
import khem.project.service.UsersService;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class UsersServiceIMPL implements UsersService{

    @Autowired
    private UsersRepository repository;

    @Override
    public UsersModel add(UserDTO entity) {
        return repository.save(UserMapper.INSTANCE.toUser(entity));
    }

    @Override
    public UsersModel getById(Long id) {
        return repository.findById(id).orElseThrow(
            () -> new APIException(HttpStatus.NOT_FOUND, String.format("Course not found for id=%d", id)));
    }
    
}
