package com.rest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//      private List<Topic> topics = new ArrayList<>(Arrays.asList(
//            new Topic("Spring", "Spring Framework", "desc1"),
//            new Topic("Java", "Java Framework", "desc2"),
//            new Topic("JS", "JS Framework", "desc3")
//            ));

      public List<Topic> getAllTopics(){
          //return topics;
          List<Topic> topics = new ArrayList<>();
          topicRepository.findAll().forEach(topics::add);
          return topics;
      }

      public Topic getTopic(String id){
          //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
         Topic topic = topicRepository.findById(id).get();
         return topic;
      }

      public void addTopic(Topic topic){
         // topics.add(topic);
          topicRepository.save(topic);
      }

      public void updateTopic(String id, Topic topic) {
//          for(int i=0; i<= topics.size(); i++){
//              Topic t = topics.get(i);
//              if(t.getId().equals(id)){
//                  topics.set(i, topic);
//                  return;
//              }
//          }
          topicRepository.save(topic);
      }

    public void deleteTopic(String id) {
          //topics.removeIf( t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}
