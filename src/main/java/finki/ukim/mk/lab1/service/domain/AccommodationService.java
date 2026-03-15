package finki.ukim.mk.lab1.service.domain;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import finki.ukim.mk.lab1.model.dto.CreateAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Accommodation create(CreateAccommodationDto dto);

    Optional<Accommodation> update(Long id, CreateAccommodationDto dto);

    Optional<Accommodation> deleteById(Long id);

    Accommodation rent(Long id);
}