package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.CommuneDto;
import fr.uga.miage.m1.entities.Commune;

@Mapper(componentModel = "spring")
public interface CommuneMapper {
    CommuneDto toDto(Commune festival);
    Commune toEntity(CommuneDto dto);
}
