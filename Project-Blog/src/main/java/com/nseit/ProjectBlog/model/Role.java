package com.nseit.ProjectBlog.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Data
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    private String role;
}
