package com.studentfeedback.controller;

import com.studentfeedback.dto.FeedbackSummaryDTO;
import com.studentfeedback.repository.FeedbackResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private FeedbackResponseRepository feedbackResponseRepository;

    @GetMapping("/feedback/overall")
    public List<FeedbackSummaryDTO> getOverallFeedback() {
        // Aggregate feedback data for all courses
        return feedbackResponseRepository.getAggregatedFeedback();
    }
}
