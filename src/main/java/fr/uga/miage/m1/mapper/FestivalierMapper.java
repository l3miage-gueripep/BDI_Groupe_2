package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.FestivalierDto;
import fr.uga.miage.m1.entities.Festivalier;

@Mapper(componentModel = "spring")
public interface FestivalierMapper {
    FestivalierDto toDto(Festivalier festival);
    Festivalier toEntity(FestivalierDto dto);
}
