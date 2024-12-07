package com.akshat.joblisting.Repositories;

import java.util.List;

import com.akshat.joblisting.Models.post;

public interface searchRepo {
    List<post> findByText(String text);
}
