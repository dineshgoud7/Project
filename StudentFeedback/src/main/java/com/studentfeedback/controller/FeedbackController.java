package com.studentfeedback.controller;

import com.studentfeedback.model.FeedbackRequest; // Import the FeedbackRequest class
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        // Logic to save feedback (e.g., save to database)
        System.out.println("Feedback received from student ID: " + feedbackRequest.getStudentId());
        System.out.println("Course ID: " + feedbackRequest.getCourseId());
        System.out.println("Rating: " + feedbackRequest.getRating());
        System.out.println("Comments: " + feedbackRequest.getComments());

        // Return a success message
        return ResponseEntity.ok("Feedback submitted successfully!");
    }
}
