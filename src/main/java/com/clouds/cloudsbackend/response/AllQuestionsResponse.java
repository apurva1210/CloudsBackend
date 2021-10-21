package com.clouds.cloudsbackend.response;

import com.clouds.cloudsbackend.model.Quiz;

import java.util.List;

public class AllQuestionsResponse extends BaseResponse
{
    private List<Quiz> quizList;

    public List<Quiz> getQuizList() {
        return this.quizList;
    }

    public void setQuizList(final List<Quiz> quizList) {
        this.quizList = quizList;
    }
}
