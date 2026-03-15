package finki.ukim.mk.lab1.model.dto;

import finki.ukim.mk.lab1.model.domain.Country;

public record CreateCountryDto(
        String name,
        String continent
) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}
