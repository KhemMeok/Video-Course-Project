package khem.project.DTO;

import java.sql.Date;

import khem.project.Enum.Gender;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;

 
    private String username;

 
    private String Password;

 
    private String email;

 
    private String phoneNumber;

 
    private Date DOB;

 
 
    private Gender gender;

 
    private String photo;

 
    private Date joinDate;
}
