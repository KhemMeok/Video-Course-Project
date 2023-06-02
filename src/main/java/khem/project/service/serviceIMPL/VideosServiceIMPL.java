package khem.project.service.serviceIMPL;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import khem.project.DTO.VideosDTO;
import khem.project.Mapper.VideosMapper;
import khem.project.model.VideoModel;
import khem.project.repository.VideosRepository;
import khem.project.service.VideosService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VideosServiceIMPL implements VideosService {

    private final VideosRepository videosRepository;

    private final VideosMapper videosMapper;

    @Override
    public VideoModel save(VideosDTO dto) {
        return videosRepository.save(videosMapper.toVideosModel(dto));
    }

    @Override
    public VideoModel getById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public VideoModel Update(Long id, VideosDTO source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<VideosDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Page<VideosDTO> getCoursePage(Map<String, String> param) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCoursePage'");
    }
    
}
