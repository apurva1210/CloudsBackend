package com.clouds.cloudsbackend.repo;

import com.clouds.cloudsbackend.model.Quiz;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    Quiz findByQuestion(final String question);

    List<Quiz> findAll();

    void deleteById(final String id);

    Optional<Quiz> findById(final String id);
}
