package com.nseit.ProjectBlog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private Integer password;

    @OneToMany(mappedBy = "userModel", cascade = CascadeType.ALL)
    private List<PostModel> postModels;
}
