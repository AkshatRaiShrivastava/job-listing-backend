package com.akshat.joblisting.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.akshat.joblisting.Models.post;

public interface postRepo extends MongoRepository<post, String> {
    
}
