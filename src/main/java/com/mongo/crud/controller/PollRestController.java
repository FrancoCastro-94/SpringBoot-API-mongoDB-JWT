
package com.mongo.crud.controller;

import com.mongo.crud.entity.ModelPoll;
import com.mongo.crud.service.PollService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poll")
public class PollRestController {
    
    @Autowired
    private PollService pollService;
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/all")
    public List<ModelPoll> showAll(){
        return this.pollService.findAllEncuestas();
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/vote/{id}/{field}")
    public String vote(@PathVariable("id") String id, @PathVariable("field") String field){
        return this.pollService.addVote(field, id);
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{id}")
    public ModelPoll showOne(@PathVariable("id") String id){
        return this.pollService.findOne(id);
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/new")
    public String saveEncuestaController(@RequestBody ModelPoll modelPoll){
        return this.pollService.savePoll(modelPoll);
    }
    
    @PreAuthorize("hasRole('ROLE_USER')")
    @PutMapping("/update")
    public String updateOne(@RequestBody ModelPoll modelPoll){
        return this.pollService.updatePoll(modelPoll);
    }
    
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public String deletePollById(@PathVariable("id") String id){
        return this.pollService.deleteOne(id);
    }


}
