package com.fc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fc.model.Topic;


public interface TopicMapper {

    List<Topic> listTopic();

    List<String> listImage();

    List<Topic> serchTopic(@Param("tid") int tid);

}
