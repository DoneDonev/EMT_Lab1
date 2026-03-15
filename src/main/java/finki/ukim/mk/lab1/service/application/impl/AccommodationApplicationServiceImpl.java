package finki.ukim.mk.lab1.service.application.impl;

import finki.ukim.mk.lab1.model.dto.CreateAccommodationDto;
import finki.ukim.mk.lab1.model.dto.DisplayAccommodationDto;
import finki.ukim.mk.lab1.service.application.AccommodationApplicationService;
import finki.ukim.mk.lab1.service.domain.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll()
                .stream()
                .map(DisplayAccommodationDto::from)
                .toList();
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public DisplayAccommodationDto create(CreateAccommodationDto createAccommodationDto) {
        return DisplayAccommodationDto.from(accommodationService.create(createAccommodationDto));
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        return accommodationService.update(id, createAccommodationDto)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> deleteById(Long id) {
        return accommodationService.deleteById(id)
                .map(DisplayAccommodationDto::from);
    }

    @Override
    public DisplayAccommodationDto rent(Long id) {
        return DisplayAccommodationDto.from(accommodationService.rent(id));
    }
}