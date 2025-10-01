package webseite.com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import webseite.com.app.model.Detalleorden;

@Repository
public interface DetalleordenRepository extends JpaRepository<Detalleorden, Integer> {

}
