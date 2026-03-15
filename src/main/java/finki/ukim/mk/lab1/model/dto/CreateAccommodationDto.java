package finki.ukim.mk.lab1.model.dto;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import finki.ukim.mk.lab1.model.domain.Host;
import finki.ukim.mk.lab1.model.enums.Category;
import finki.ukim.mk.lab1.model.enums.State;

import java.util.concurrent.locks.Condition;

public record CreateAccommodationDto(
        String name,
        Category category,
        Long hostId,
        State state,
        Integer numRooms,
        Boolean rented
) {
    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, state, numRooms, rented);
    }
}
