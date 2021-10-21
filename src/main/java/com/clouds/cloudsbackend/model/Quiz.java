package com.clouds.cloudsbackend.model;



import org.springframework.data.annotation.Id;

public class Quiz
{
    @Id
    private String id;
    private String question;
    private String answer;

    public String getQuestion() {
        return this.question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public String getId() {
        return this.id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
