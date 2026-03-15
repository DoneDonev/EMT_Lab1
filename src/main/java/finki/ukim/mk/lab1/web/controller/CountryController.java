package finki.ukim.mk.lab1.web.controller;

import finki.ukim.mk.lab1.model.dto.CreateCountryDto;
import finki.ukim.mk.lab1.model.dto.DisplayCountryDto;
import finki.ukim.mk.lab1.service.application.CountryApplicationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCountryDto>> findAll() {
        return ResponseEntity.ok(countryApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id) {
        return countryApplicationService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> create(
            @RequestBody @Valid CreateCountryDto createCountryDto) {
        return ResponseEntity.ok(countryApplicationService.create(createCountryDto));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update(
            @PathVariable Long id,
            @RequestBody @Valid CreateCountryDto createCountryDto) {
        return countryApplicationService.update(id, createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DisplayCountryDto> delete(@PathVariable Long id) {
        return countryApplicationService.deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}