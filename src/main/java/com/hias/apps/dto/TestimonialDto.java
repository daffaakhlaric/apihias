package com.hias.apps.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestimonialDto {

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("rating")
    private Long rating;

    @JsonCreator
    public TestimonialDto(
            @JsonProperty("userId") Long userId,
            @JsonProperty("comment") String comment,
            @JsonProperty("rating") Long rating) {
        this.userId = userId;
        this.comment = comment;
        this.rating = rating;
    }

    public Long getUserId(Long userId) {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getComment(String comment) {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getRating(Long rating) {
        return this.rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
