package finki.ukim.mk.lab1.service.application.impl;

import finki.ukim.mk.lab1.model.domain.Country;
import finki.ukim.mk.lab1.model.dto.CreateHostDto;
import finki.ukim.mk.lab1.model.dto.DisplayHostDto;
import finki.ukim.mk.lab1.model.exception.CountryNotFoundException;
import finki.ukim.mk.lab1.repository.CountryRepository;
import finki.ukim.mk.lab1.service.application.HostApplicationService;
import finki.ukim.mk.lab1.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    private final CountryRepository countryRepository;

    public HostApplicationServiceImpl(HostService hostService, CountryRepository countryRepository) {
        this.hostService = hostService;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll()
                .stream()
                .map(DisplayHostDto::from)
                .toList();
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id)
                .map(DisplayHostDto::from);
    }

    @Override
    public DisplayHostDto create(CreateHostDto createHostDto) {
        Country country = countryRepository.findById(createHostDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createHostDto.countryId()));
        return DisplayHostDto.from(hostService.create(createHostDto.toHost(country)));
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Country country = countryRepository.findById(createHostDto.countryId())
                .orElseThrow(() -> new CountryNotFoundException(createHostDto.countryId()));
        return hostService.update(id, createHostDto.toHost(country))
                .map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> deleteById(Long id) {
        return hostService.deleteById(id)
                .map(DisplayHostDto::from);
    }
}