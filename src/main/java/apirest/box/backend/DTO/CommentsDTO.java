package apirest.box.backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class CommentsDTO {
    @Getter @Setter
    private UUID id;

    @Getter @Setter
    private String contenido;

    @Getter @Setter
    private String fecha;



}
