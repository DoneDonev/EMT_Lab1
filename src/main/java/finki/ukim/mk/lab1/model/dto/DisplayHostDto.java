package finki.ukim.mk.lab1.model.dto;

import finki.ukim.mk.lab1.model.domain.Host;

import java.util.List;

public record DisplayHostDto(
        Long id,
        String name,
        String surname,
        Long country_id
) {
    public static DisplayHostDto from(Host host) {
        return new DisplayHostDto(
                host.getId(),
                host.getName(),
                host.getSurname(),
                host.getCountry().getId()
        );
    }

    public static List<DisplayHostDto> from(List<Host> hosts) {
        return hosts.stream().map(DisplayHostDto::from).toList();
    }
}
