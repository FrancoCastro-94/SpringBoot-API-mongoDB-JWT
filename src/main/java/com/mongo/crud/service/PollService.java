
package  com.mongo.crud.service;

import com.mongo.crud.entity.ModelPoll;
import com.mongo.crud.repository.PollRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PollService {
    
    @Autowired
    private PollRepository pollRepository;
    
    @Transactional
    public String addVote(String field, String id){
        Optional<ModelPoll> response = this.pollRepository.findById(id);
        if(response.isPresent()){
            ModelPoll encuesta = response.get();
            HashMap<String, Integer> poll = encuesta.getFielsAndCounts();
            poll.put(field, poll.get(field)+1);
            encuesta.setFielsAndCounts(poll);
            this.pollRepository.save(encuesta);
            return "ok";
        } else {
            return "No fund";
        }
    }
    
    @Transactional
    public ModelPoll findOne(String id){
        ModelPoll modelPoll = new ModelPoll();
        Optional<ModelPoll> response = this.pollRepository.findById(id);
        if(response.isPresent()){
            modelPoll = response.get();
        }
        return modelPoll;
    }
    
    @Transactional
    public String savePoll(ModelPoll modelPoll){
        try{
            this.pollRepository.save(modelPoll);
            return "ok";
        } catch (Exception e){
           // System.out.println(e.toString());
            return "error";
        }
    }
    
    @Transactional
    public List<ModelPoll> findAllEncuestas(){
        try{
            return this.pollRepository.findAll();
        } catch (Exception e){
            // System.out.println(e.toString());
            return null;
        }

    }
    
    @Transactional
    public String deleteOne(String id){
        try{
            this.pollRepository.deleteById(id);
            return "ok";
        }catch(Exception e){
            // System.out.println(e.toString());
            return "error";
        }
    }
    
    @Transactional
    public String updatePoll(ModelPoll modelPoll){
        try{
            this.pollRepository.save(modelPoll);
            return "ok";
        } catch (Exception e){
           // System.out.println(e.toString());
            return "error";
        }
    }
}
