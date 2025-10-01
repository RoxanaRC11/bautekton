package webseite.com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webseite.com.app.model.Galeria;

@Repository
public interface GaleriaRepository extends JpaRepository<Galeria, Integer> {

}
