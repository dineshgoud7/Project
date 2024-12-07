package com.studentfeedback.model;



import jakarta.persistence.*;

@Entity
public class FeedbackResponse {

    @Id
    private Long id;

    private Long courseId; // ID of the course being rated

    @ManyToOne
    private Student student; // Relationship with the Student entity

    private int rating;
    private String comments;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
