package com.nseit.ProjectBlog.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;

@Entity
@Data
public class PostModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String Title;
    private String description;
    private Image image;
}
