package Oussama;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class ReclamationService {
    @Autowired
    ReclamationRepository r;

    public List<reclamation> retrieveAllReclamation() {
        return (List<reclamation>) r.findAll();
    }


    public reclamation addReclamation(reclamation rr) {
        return r.save(rr);
    }


    public void deleteReclamation(Long id) {
        Optional<reclamation> optionalReclamation = r.findById(id);
        if (!optionalReclamation.isPresent()) {
            throw new IllegalStateException("Reclamation Not Found");
        }
        r.deleteById(id);

    }


    public void deleteReclamation(String id) {


        r.deleteById(Long.parseLong(id));
    }


    public reclamation updateReclamation(Long id,reclamation rr) {
        reclamation result=null;
        Optional<reclamation> rec=this.r.findById(id);
        if(rec.isPresent())
        {
            result=rec.get();
            this.r.save(rr);
        }
        else
            throw new IllegalStateException("Id not found");
        return result;
    }


    public Optional<reclamation> FindReclamation(Long id) {
        return r.findById(id);
    }


    public Optional<reclamation> FindReclamation(String id) {

        return r.findById(Long.parseLong(id));
    }
}
