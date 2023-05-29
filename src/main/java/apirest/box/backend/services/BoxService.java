package apirest.box.backend.services;

import apirest.box.backend.models.BoxModel;
import apirest.box.backend.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<BoxModel> getAllBox(){
        return this.boxRepository.findAll();
    }

    public Optional<BoxModel> findBox(UUID id){
        return this.boxRepository.findById(id);
    }

    public BoxModel addBox(BoxModel boxModel){
        return this.boxRepository.save(boxModel);
    }
}
