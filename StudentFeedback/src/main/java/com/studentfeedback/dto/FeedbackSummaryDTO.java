package com.studentfeedback.dto;

public class FeedbackSummaryDTO {

    private String courseName;
    private Double averageRating;

    public FeedbackSummaryDTO(String courseName, Double averageRating) {
        this.courseName = courseName;
        this.averageRating = averageRating;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
