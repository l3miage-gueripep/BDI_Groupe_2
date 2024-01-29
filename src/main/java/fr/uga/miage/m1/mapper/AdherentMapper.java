package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.AdherentDto;
import fr.uga.miage.m1.entities.Adherent;

@Mapper(componentModel = "spring")
public interface AdherentMapper {
    AdherentDto toDto(Adherent festival);
    Adherent toEntity(AdherentDto dto);
}
