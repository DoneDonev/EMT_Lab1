package finki.ukim.mk.lab1.service.domain;

import finki.ukim.mk.lab1.model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> findAll();

    Optional<Host> findById(Long id);

    Host create(Host host);

    Optional<Host> update(Long id, Host host);

    Optional<Host> deleteById(Long id);
}
