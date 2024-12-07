package com.akshat.joblisting.Repositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import com.akshat.joblisting.Models.post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class searchRepoImplement implements searchRepo {
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<post> findByText(String text) {
        // TODO Auto-generated method stub
        final List<post> posts = new ArrayList<>();
        MongoDatabase database = client.getDatabase("jobListing");
        MongoCollection<Document> collection = database.getCollection("jobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("techs", "desc", "profile"))))));
                // new Document("$sort",
                //         new Document("exp", 1L))));
        
        result.forEach(doc -> posts.add(converter.read(post.class, doc)));

        return posts;
    }

}