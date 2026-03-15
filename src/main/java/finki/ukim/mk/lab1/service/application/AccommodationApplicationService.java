package finki.ukim.mk.lab1.service.application;

import finki.ukim.mk.lab1.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab1.model.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();

    Optional<DisplayAccommodationDto> findById(Long id);

    DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> deleteById(Long id);

    DisplayAccommodationDto rent(Long id);
}