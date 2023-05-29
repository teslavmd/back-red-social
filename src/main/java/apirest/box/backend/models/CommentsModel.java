package apirest.box.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "comentarios")
public class CommentsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter @Setter
    private UUID id;

    @Column(name = "contenido")
    @Getter @Setter
    private String contenido;

    @Column(name = "fecha")
    @Getter @Setter
    private String fecha;

    @ManyToOne
    @JoinColumn(name = "id_box")
    @JsonBackReference
    @Getter @Setter
    private BoxModel boxModel;


}
