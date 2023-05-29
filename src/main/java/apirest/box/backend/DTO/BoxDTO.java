package apirest.box.backend.DTO;

import apirest.box.backend.models.CommentsModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BoxDTO {
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private String foto;

    @Getter @Setter
    private String fecha;

    @Getter @Setter
    private List<CommentsDTO> commentsModelList = new ArrayList<>();



}
