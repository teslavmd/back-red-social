package apirest.box.backend.repository;


import apirest.box.backend.models.BoxModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface BoxRepository extends JpaRepository<BoxModel, UUID> {
}
