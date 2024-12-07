package com.studentfeedback.controller;

import com.studentfeedback.dto.FeedbackSummaryDTO;
import com.studentfeedback.model.FeedbackResponse;
import com.studentfeedback.repository.FeedbackResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FeedbackResponseRepository feedbackResponseRepository;

    // Get feedback for a specific course based on courseId
    @GetMapping("/feedback/{courseId}")
    public List<FeedbackResponse> getCourseFeedback(@PathVariable Long courseId) {
        // Fetch feedback specific to the given course ID
        return feedbackResponseRepository.findByCourseId(courseId);
    }

    // Get aggregated feedback for all courses
    @GetMapping("/feedback/overall")
    public List<FeedbackSummaryDTO> getOverallFeedback() {
        return feedbackResponseRepository.getAggregatedFeedback();
    }
}
