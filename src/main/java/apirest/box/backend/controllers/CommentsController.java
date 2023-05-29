package apirest.box.backend.controllers;

import apirest.box.backend.models.BoxModel;
import apirest.box.backend.models.CommentsModel;
import apirest.box.backend.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200/")
public class CommentsController {

    @Autowired
    CommentsService commentsService;

    @PostMapping("/comments/{id}")
    public CommentsModel addComment(@RequestBody CommentsModel commentsModel, @PathVariable String id){

        UUID uuid;

        uuid = UUID.fromString(id);

        BoxModel boxModel = new BoxModel();
        boxModel.setId(uuid);
        commentsModel.setBoxModel(boxModel);

        return commentsService.addComment(commentsModel);
    }


}
