package com.clouds.cloudsbackend.controller;

import com.clouds.cloudsbackend.model.Quiz;
import com.clouds.cloudsbackend.repo.QuizRepository;
import com.clouds.cloudsbackend.response.AllQuestionsResponse;
import com.clouds.cloudsbackend.response.BaseResponse;
import com.clouds.cloudsbackend.response.RandomQuestionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
public class ServiceController {
    @Autowired
    private QuizRepository repository;

    @RequestMapping(path = { "/getRandomQuestion" }, method = { RequestMethod.GET })
    public RandomQuestionResponse getRandomQuestion() {
        final List<Quiz> quizList = repository.findAll();
        final RandomQuestionResponse response = new RandomQuestionResponse();
        if (CollectionUtils.isEmpty(quizList)) {
            response.setMessage("No questions are added");
            return response;
        }
        final int limit = quizList.size();
        final Random rand = new Random();
        final int randNo = rand.nextInt(limit);
        final Quiz quiz = quizList.get(randNo);
        response.setQuestion(quiz.getQuestion());
        response.setAnswer(quiz.getAnswer());
        response.setId(quiz.getId());
        response.setMessage("success");
        return response;
    }

    @RequestMapping(path = { "/saveNewQuestion" }, method = { RequestMethod.POST })
    public BaseResponse saveQuestion(@RequestParam(value = "question") String question,
                                     @RequestParam(value = "answer") String answer) {
        final BaseResponse baseResponse = new BaseResponse();
        try {
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setAnswer(answer);
            repository.save(quiz);
            baseResponse.setMessage("success");
            return baseResponse;
        }
        catch (Exception e) {
            baseResponse.setMessage("fail");
            return baseResponse;
        }
    }

    @RequestMapping(path = { "/getAllQuestions" }, method = { RequestMethod.GET })
    public AllQuestionsResponse getAllQuestions() {
        final AllQuestionsResponse allQuestionsResponse = new AllQuestionsResponse();
        final List<Quiz> quizList = repository.findAll();
        if (CollectionUtils.isEmpty((Collection)quizList)) {
            allQuestionsResponse.setMessage("No Questions were added");
            return allQuestionsResponse;
        }
        allQuestionsResponse.setQuizList(quizList);
        allQuestionsResponse.setMessage("success");
        return allQuestionsResponse;
    }

    @RequestMapping(path = { "/deleteQuestion" }, method = { RequestMethod.POST })
    public BaseResponse deleteQuestion(@RequestParam(value = "questionId") String questionId) {
        final BaseResponse baseResponse = new BaseResponse();
        try {
            repository.deleteById(questionId);
            baseResponse.setMessage("success");
            return baseResponse;
        }
        catch (Exception e) {
            baseResponse.setMessage("fail");
            return baseResponse;
        }
    }

    @RequestMapping(path = { "/updateQuestion" }, method = { RequestMethod.POST })
    public BaseResponse updateQuestion(@RequestParam(value = "question") String question,
                                       @RequestParam(value = "answer") String answer,
                                       @RequestParam(value = "questionId") String questionId) {
        final BaseResponse baseResponse = new BaseResponse();
        try {
            final Optional<Quiz> quizOptional = repository.findById(questionId);
            final Quiz updateQuiz = quizOptional.get();
            updateQuiz.setQuestion(question);
            updateQuiz.setAnswer(answer);
            repository.save(updateQuiz);
            baseResponse.setMessage("success");
            return baseResponse;
        }
        catch (Exception e) {
            baseResponse.setMessage("fail");
            return baseResponse;
        }
    }
}
