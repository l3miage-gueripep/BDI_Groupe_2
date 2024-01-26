package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.OffreCovoiturageDto;
import fr.uga.miage.m1.entities.OffreCovoiturage;

@Mapper(componentModel = "spring")
public interface OffreCovoiturageMapper {
    OffreCovoiturageDto toDto(OffreCovoiturage festival);

    OffreCovoiturage toEntity(OffreCovoiturageDto dto);
}
