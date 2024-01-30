package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.PanierOffreDto;
import fr.uga.miage.m1.entities.PanierOffre;

@Mapper(componentModel = "spring", uses = {FestivalMapper.class, CovoiturageLieuMapper.class})
public interface PanierOffreMapper {
    PanierOffreDto toDto(PanierOffre panierOffre);
    PanierOffre toEntity(PanierOffreDto dto);
}
