package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Panier;

@Mapper(componentModel = "spring")
public interface PanierMapper {
    PanierDto toDto(Panier festival);
    Panier toEntity(PanierDto dto);
}
