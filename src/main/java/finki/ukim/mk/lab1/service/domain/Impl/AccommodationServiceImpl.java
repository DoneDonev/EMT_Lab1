package finki.ukim.mk.lab1.service.domain.Impl;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import finki.ukim.mk.lab1.model.domain.Host;
import finki.ukim.mk.lab1.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab1.model.exception.AccommodationNotFoundException;
import finki.ukim.mk.lab1.model.exception.HostNotFoundException;
import finki.ukim.mk.lab1.repository.AccommodationRepository;
import finki.ukim.mk.lab1.repository.HostRepository;
import finki.ukim.mk.lab1.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository,
                                    HostRepository hostRepository) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Accommodation create(CreateAccommodationDto dto) {
        Host host = hostRepository.findById(dto.hostId())
                .orElseThrow(() -> new HostNotFoundException(dto.hostId()));
        return accommodationRepository.save(dto.toAccommodation(host));
    }

    @Override
    public Optional<Accommodation> update(Long id, CreateAccommodationDto dto) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    Host host = hostRepository.findById(dto.hostId())
                            .orElseThrow(() -> new HostNotFoundException(dto.hostId()));
                    accommodation.setName(dto.name());
                    accommodation.setCategory(dto.category());
                    accommodation.setNumRooms(dto.numRooms());
                    accommodation.setHost(host);
                    accommodation.setState(dto.state());
                    accommodation.setRented(dto.rented());
                    return accommodationRepository.save(accommodation);
                });
    }

    @Override
    public Optional<Accommodation> deleteById(Long id) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    accommodationRepository.delete(accommodation);
                    return accommodation;
                });
    }

    @Override
    public Accommodation rent(Long id) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    accommodation.setRented(true);
                    return accommodationRepository.save(accommodation);
                })
                .orElseThrow(() -> new AccommodationNotFoundException(id));
    }
}