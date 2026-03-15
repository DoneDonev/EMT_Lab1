package finki.ukim.mk.lab1.model.dto;

import finki.ukim.mk.lab1.model.domain.Accommodation;
import finki.ukim.mk.lab1.model.enums.Category;
import finki.ukim.mk.lab1.model.enums.State;

import java.util.List;

public record DisplayAccommodationDto(
        Long id,
        String name,
        Category category,
        Long host_Id,
        State state,
        Integer numRooms,
        Boolean rented
) {
    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getState(),
                accommodation.getNumRooms(),
                accommodation.getRented()
        );
    }
    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).toList();
    }
}
