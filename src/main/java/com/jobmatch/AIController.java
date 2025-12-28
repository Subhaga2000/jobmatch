package com.jobmatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AIController {

    @Autowired
    private InterviewService interviewService;

    // This creates a link: POST http://localhost:8080/api/analyze
    @PostMapping("/analyze")
    public String analyze(@RequestBody MatchRequest request) {
        // Take the text from the box and give it to the AI Service
        return interviewService.analyzeResume(request.getResume(), request.getJobDesc());
    }
}