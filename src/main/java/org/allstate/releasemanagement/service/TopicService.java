package org.allstate.releasemanagement.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.allstate.releasemanagement.model.Topics;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	 private List<Topics> myTopics= new ArrayList<Topics> (Arrays.asList(new Topics("1", "Maths", "myMaths"),
	    		new Topics("2","Geography","MyGeography"),
	    		new Topics("4","History","MyHistory"),
	    		new Topics("5","Kryptography","MyKrypto")));
	
	  
	  public List<Topics> getAllTopics(){
		  
		  return myTopics;
	  }
	  
	  
	  public Topics getTopic(String id){
		  
		 return myTopics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		  
	  }
	  
	  
	  
	  public void addTopic(Topics aNewTopic){
		  //List<Topics> myNewTopics=new ArrayList<Topics>(myTopics);
		  myTopics.add(aNewTopic);
		  
	  }
}
