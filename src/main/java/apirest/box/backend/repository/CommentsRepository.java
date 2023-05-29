package apirest.box.backend.repository;

import apirest.box.backend.models.CommentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CommentsRepository extends JpaRepository<CommentsModel, UUID> {
}
