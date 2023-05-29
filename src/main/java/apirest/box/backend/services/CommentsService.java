package apirest.box.backend.services;

import apirest.box.backend.models.CommentsModel;
import apirest.box.backend.repository.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;


    public CommentsModel addComment(CommentsModel commentsModel){
        return commentsRepository.save(commentsModel);
    }

}
