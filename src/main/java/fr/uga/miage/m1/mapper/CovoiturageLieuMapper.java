package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.CovoiturageLieuDto;
import fr.uga.miage.m1.entities.CovoiturageLieu;

@Mapper(componentModel = "spring")
public interface CovoiturageLieuMapper {
    CovoiturageLieuDto toDto(CovoiturageLieu festival);
    CovoiturageLieu toEntity(CovoiturageLieuDto dto);
}
