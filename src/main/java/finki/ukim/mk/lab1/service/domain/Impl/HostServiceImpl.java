package finki.ukim.mk.lab1.service.domain.Impl;

import finki.ukim.mk.lab1.model.domain.Host;
import finki.ukim.mk.lab1.repository.HostRepository;
import finki.ukim.mk.lab1.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Host create(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id)
                .map(existing -> {
                    existing.setName(host.getName());
                    existing.setSurname(host.getSurname());
                    existing.setCountry(host.getCountry());
                    return hostRepository.save(existing);
                });
    }

    @Override
    public Optional<Host> deleteById(Long id) {
        return hostRepository.findById(id)
                .map(existing -> {
                    hostRepository.delete(existing);
                    return existing;
                });
    }
}