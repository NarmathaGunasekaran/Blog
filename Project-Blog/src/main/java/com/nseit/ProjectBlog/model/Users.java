package com.nseit.ProjectBlog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String email;
    private Integer password;
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Post> postModels;
}
