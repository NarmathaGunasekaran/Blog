package com.nseit.ProjectBlog.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String  image;
    @ManyToOne
    @JoinColumn(name = "users_Id", nullable = false,referencedColumnName = "userId")
    private UserModel userModel;
}
