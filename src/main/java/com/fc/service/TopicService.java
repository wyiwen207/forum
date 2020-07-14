package com.fc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.mapper.TopicMapper;
import com.fc.model.Topic;


@Service
public class TopicService {


    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> listTopic() {
        return topicMapper.listTopic();
    }

    public List<String> listImage() {
        return topicMapper.listImage();
    }

    public List<Topic> serchTopic(int tid) {
        return topicMapper.serchTopic(tid);
    }
}

