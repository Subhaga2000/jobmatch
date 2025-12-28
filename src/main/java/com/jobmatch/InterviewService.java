package com.jobmatch;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class InterviewService {

    private final ChatClient chatClient;

    public InterviewService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // This function takes the Resume and Job Description and asks the AI for help
    public String analyzeResume(String resumeText, String jobDescription) {

        // This is the instruction we send to Llama 3
        String prompt = """
            You are an expert Career Coach.
            
            RESUME:
            %s
            
            JOB DESCRIPTION:
            %s
            
            Task:
            1. Give a match score (0-100).
            2. List 3 keywords missing from the resume.
            3. Rewrite the Profile Summary to match the job description better.
            """.formatted(resumeText, jobDescription);

        // Send to AI and get the answer
        return chatClient.prompt().user(prompt).call().content();
    }
}