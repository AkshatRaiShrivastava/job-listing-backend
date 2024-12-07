package com.akshat.joblisting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akshat.joblisting.Models.post;
import com.akshat.joblisting.Repositories.postRepo;
import com.akshat.joblisting.Repositories.searchRepo;

@RestController
public class postController {
    @Autowired
    postRepo repo;
    @Autowired
    searchRepo search;
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/post")
    public ResponseData addPost(@RequestBody post post){
        System.out.println(repo.save(post)); 
        return new ResponseData("Job posted");
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/posts")
    public List<post> getAllPosts(){    
        return repo.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/posts/{text}")
    public List<post> search(@PathVariable String text){
        return search.findByText(text);
    }
    public static class ResponseData {
        private String message;

        public ResponseData(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
 