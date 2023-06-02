package khem.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import khem.project.DTO.VideosDTO;
import khem.project.model.VideoModel;

public interface VideosService {
    VideoModel save(VideosDTO dto);
    VideoModel getById(Long id);
    VideoModel Update(Long id,VideosDTO source);
    void delete(Long id);
    List<VideosDTO> findAll();
    Page<VideosDTO> getCoursePage(Map<String,String> param);
}
