package khem.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import khem.project.model.VideoModel;

@Repository
public interface VideosRepository extends JpaRepository<VideoModel,Long>, JpaSpecificationExecutor<VideoModel>{
    
}
