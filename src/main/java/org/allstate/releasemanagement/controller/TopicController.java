package org.allstate.releasemanagement.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.allstate.releasemanagement.model.Topics;
import org.allstate.releasemanagement.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TopicController {

	@Autowired
	private TopicService myTopicService;

	@RequestMapping("/topic")
	public ModelAndView getTopics() {
        Map<String, Object> model = new HashMap<>();
         Topics myTopic= myTopicService.getTopic("4");
         model.put("Topic", myTopic);
        return new ModelAndView("index", model);
	}
	
	@RequestMapping("/home")
	public String home() {
        return "index";
	}


	@RequestMapping("/topics")
	public List<Topics> getAllTopics() {

		return myTopicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public Topics getTopics(@PathVariable String id) {
		return myTopicService.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topics aNewTopic){
		 myTopicService.addTopic(aNewTopic);
		
	}
}
