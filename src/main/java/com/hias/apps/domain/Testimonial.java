package com.hias.apps.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hias.apps.domain.audit.DateAudit;

@Entity
@Table(name = "testimonial")
public class Testimonial extends DateAudit implements Serializable{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable=false, updatable=false)
    @JsonProperty("userId")
    private User user;

    @JsonProperty("comment")
    @Column(name = "comment", nullable = true)
    private String comment;


    @JsonProperty("rating")
    @Column(name = "rating", nullable = true)
    private Long rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
