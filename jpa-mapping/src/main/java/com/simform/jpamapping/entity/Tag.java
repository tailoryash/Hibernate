package com.simform.jpamapping.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.util.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    @NaturalId
    private String name;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Tag(@NotNull String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "tags")
    private Set<Post> posts = new HashSet<>();
}
