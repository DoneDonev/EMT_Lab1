package finki.ukim.mk.lab1.repository;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {

}
