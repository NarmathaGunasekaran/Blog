package com.nseit.ProjectBlog.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
@Data
public class RoleModel {
    @Id
    @GeneratedValue
    private Integer id;
    private String role;
}
