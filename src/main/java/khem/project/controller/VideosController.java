package khem.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import khem.project.DTO.VideosDTO;
import khem.project.Mapper.VideosMapper;
import khem.project.model.VideoModel;
import khem.project.service.VideosService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/videos")
@RequiredArgsConstructor
public class VideosController {

    private final VideosService service;


    @PostMapping
    public ResponseEntity<?> add(@RequestBody VideosDTO videosDTO){
        VideoModel videos = service.save(videosDTO);
        return ResponseEntity.ok().body(VideosMapper.INSTANCE.toVIdeoDTO(videos));
    }

}
