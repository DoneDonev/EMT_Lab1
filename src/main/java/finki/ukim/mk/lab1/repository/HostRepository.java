package finki.ukim.mk.lab1.repository;

import finki.ukim.mk.lab1.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
