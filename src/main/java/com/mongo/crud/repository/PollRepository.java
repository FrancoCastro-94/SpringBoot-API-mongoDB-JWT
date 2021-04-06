
package com.mongo.crud.repository;

import com.mongo.crud.entity.ModelPoll;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface PollRepository extends MongoRepository<ModelPoll, String>{
    
}
