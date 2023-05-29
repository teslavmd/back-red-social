package apirest.box.backend.controllers;



import apirest.box.backend.DTO.BoxDTO;
import apirest.box.backend.DTO.CommentsDTO;
import apirest.box.backend.models.BoxModel;
import apirest.box.backend.models.CommentsModel;
import apirest.box.backend.services.BoxService;
import apirest.box.backend.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:4200")
public class BoxController {

    @Autowired
    BoxService boxService;

    @Autowired
    CommentsService commentsService;


    @GetMapping("/box")
    public List<BoxModel> getBox(){
        return boxService.getAllBox();
    }

    @GetMapping("/box/{id}")
    public BoxDTO searchBox(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        BoxModel box = boxService.findBox(id).orElseThrow(ChangeSetPersister.NotFoundException::new);


        BoxDTO boxDTO = new BoxDTO();
        boxDTO.setTitulo(box.getTitulo());
        boxDTO.setId(box.getId());
        boxDTO.setFoto(box.getFoto());
        boxDTO.setFecha(box.getFecha());
        boxDTO.setDescripcion(box.getDescripcion());

        List<CommentsDTO> commentsDTOS = box.getCommentsModelList().stream().map(comment -> {
            CommentsDTO commentsDTO = new CommentsDTO();
            commentsDTO.setId(comment.getId());
            commentsDTO.setFecha(comment.getFecha());
            commentsDTO.setContenido(comment.getContenido());

            return commentsDTO;
        }).collect(Collectors.toList());

        boxDTO.setCommentsModelList(commentsDTOS);

        return boxDTO;
    }

    @PostMapping("/box")
    public BoxModel addBox(@RequestBody BoxModel box){
        return boxService.addBox(box);
    }
}
