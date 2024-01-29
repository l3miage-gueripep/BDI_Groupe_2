package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.LieuCovoiturageDto;
import fr.uga.miage.m1.entities.LieuCovoiturage;

@Mapper(componentModel = "spring")
public interface LieuCovoiturageMapper {
    LieuCovoiturageDto toDto(LieuCovoiturage festival);
    LieuCovoiturage toEntity(LieuCovoiturageDto dto); 

}
