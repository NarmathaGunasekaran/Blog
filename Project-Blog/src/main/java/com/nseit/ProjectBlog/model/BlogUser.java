package com.nseit.ProjectBlog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @ManyToMany(mappedBy = "blogUsers", cascade = CascadeType.ALL)
    private Set<Post> posts;
    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")})
    private Set<Role> roles;

    public BlogUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
