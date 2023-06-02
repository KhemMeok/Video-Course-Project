package khem.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import khem.project.model.UsersModel;
@Repository
public  interface UsersRepository extends JpaRepository<UsersModel,Long>, JpaSpecificationExecutor<UsersModel>  {
    
}
