package apirest.box.backend.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "box_model")
public class BoxModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter @Setter
    private UUID id;


    @Column(name = "titulo", nullable = false)
    @Getter @Setter
    private String titulo;


    @Column(name = "descripcion")
    @Getter @Setter
    private String descripcion;

    @Column(name = "foto")
    @Getter @Setter
    private String foto;

    @Column(name = "fecha")
    @Getter @Setter
    private String fecha;

    @OneToMany(mappedBy = "boxModel")
    @JsonManagedReference
    @Getter @Setter
    private List<CommentsModel> commentsModelList = new ArrayList<>();





}
