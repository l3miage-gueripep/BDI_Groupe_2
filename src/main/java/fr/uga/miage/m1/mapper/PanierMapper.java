package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Panier;

@Mapper(componentModel = "spring", uses = PanierOffreMapper.class)
public interface PanierMapper {
    @Mapping(source = "adherent.mail", target = "userMail")
    PanierDto toDto(Panier festival);
    Panier toEntity(PanierDto dto);
}
