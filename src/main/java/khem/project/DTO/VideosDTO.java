package khem.project.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VideosDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("course_id")
    private Integer courseId;
    @JsonProperty("video_title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("video_link")
    private String link;
    @JsonProperty("video_image_cover")
    private String imageCover;
    @JsonProperty("video_create_date")
    private String createDate;
    @JsonProperty("video_date_modified")
    private String dateModified;
    @JsonProperty("video_create_by")
    private Integer usersCreate;
    @JsonProperty("video_modified_by")
    private Integer usersModified;
}
