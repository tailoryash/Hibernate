package com.simform.jpamapping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "posts")
public class Post {

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", postedAt=" + postedAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", tags=" + tags +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 200)
    @Column(unique = true)
    private String title;


    @NotNull
    @Size(max = 250)
    private String description;

    @NotNull
    @Lob
    private String content;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_at")
    private Date lastUpdatedAt = new Date();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private Set<Tag> tags = new HashSet<>();

    public Post() {
    }

    public Post(@NotNull String title, @NotNull String description, @NotNull String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(Date lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
