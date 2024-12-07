package com.studentfeedback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studentfeedback.dto.FeedbackSummaryDTO;
import com.studentfeedback.model.FeedbackResponse;

public interface FeedbackResponseRepository extends JpaRepository<FeedbackResponse, Long> {

    // Find feedback by courseId
    List<FeedbackResponse> findByCourseId(Long courseId);

    // Find feedback by studentId
    List<FeedbackResponse> findByStudentId(Long studentId);

    // Aggregate feedback for each course
    @Query("SELECT new com.studentfeedback.dto.FeedbackSummaryDTO(c.name, AVG(fr.rating)) " +
           "FROM FeedbackResponse fr JOIN fr.course c " +
           "GROUP BY c.name")
    List<FeedbackSummaryDTO> getAggregatedFeedback();
}
