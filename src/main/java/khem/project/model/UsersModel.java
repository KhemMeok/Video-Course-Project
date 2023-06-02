package khem.project.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import khem.project.Enum.Gender;
import lombok.Data;
@Data
@Entity
@Table(name = "users")
public class UsersModel {
    @Id
    @GeneratedValue(generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator", initialValue = 1, sequenceName = "user_seq_generator",  allocationSize = 1)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String Password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "dob")
    private Date DOB;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "photo")
    private String photo;

    @Column(name = "join_date")
    private Date joinDate;
}
