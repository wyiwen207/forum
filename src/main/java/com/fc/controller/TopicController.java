package com.fc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fc.model.PageBean;
import com.fc.model.Post;
import com.fc.model.Topic;
import com.fc.model.User;
import com.fc.service.PostService;
import com.fc.service.TopicService;
import com.fc.service.UserService;

@Controller
@RequestMapping("/")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    /**
     * 列出所有话题
     * @param model
     * @return
     */
    @RequestMapping("/listTopic.do")
    public String listTopic(Model model){
        List<Topic> topicList = topicService.listTopic();
        model.addAttribute("topicList",topicList);
        return "topic";
    }

    @RequestMapping("/listImage.do")
    public String listImage(Model model,HttpServletRequest request){
//        List<String> imageList = topicService.listImage();
//        model.addAttribute("imageList",imageList);
//        return "image";
    	System.out.println(request.getRemoteAddr());
        //记录访问信息
        userService.record(request.getRequestURL(),request.getContextPath(),request.getRemoteAddr());
        //列出帖子
        PageBean<Post> pageBean = postService.listPostByTime(1);
        //列出用户
        List<User> userList = userService.listUserByTime();
        //列出活跃用户
        List<User> hotUserList = userService.listUserByHot();
        //向模型中添加数据
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("userList",userList);
        model.addAttribute("hotUserList",hotUserList);
        return "image";
    }

    @RequestMapping("/serchTopic.do")
    public String serchTopic(Model model ,@RequestParam(value="tid") int tid){
    	List<Topic> searchTopic = topicService.serchTopic(tid);
        model.addAttribute("topicList",searchTopic);
        return "topic";
    }
}





