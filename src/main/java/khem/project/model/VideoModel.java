package khem.project.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "videos")
@Data
public class VideoModel {
    @Id
    @GeneratedValue(generator = "video_seq_generator")
    @SequenceGenerator(name = "video_seq_generator", initialValue = 1, sequenceName = "video_seq_generator",  allocationSize = 1)
    private Long id;

   
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseModel course;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "image_cover")
    private String imageCover;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "date_modified")
    private Date dateModified;

    @OneToOne
    @JoinColumn(name = "users_create")
    private UsersModel usersCreate;

    @OneToMany
    @JoinTable(
        name = "user_id",  
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns =  @JoinColumn(name = "video_id")
    )
    private List<UsersModel> usersModified;
    
}
