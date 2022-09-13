package com.nseit.blogSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class BlogUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    @JsonIgnore
    @ManyToMany(mappedBy = "blogUser", cascade = CascadeType.ALL)
    private Set<Post> posts;

    @ManyToMany
    @JsonIgnore
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> roles;

    public BlogUser() {
    }

    public BlogUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "blogUser", cascade = CascadeType.REMOVE)
    private Set<Comment> comments;

}
