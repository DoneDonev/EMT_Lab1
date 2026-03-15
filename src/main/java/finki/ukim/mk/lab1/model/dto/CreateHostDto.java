package finki.ukim.mk.lab1.model.dto;

import finki.ukim.mk.lab1.model.domain.Country;
import finki.ukim.mk.lab1.model.domain.Host;

public record CreateHostDto(
        String name,
        String surname,
        Long countryId
) {
    public Host toHost(Country country) {
        return new Host(name, surname, country);
    }
}
