package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.DomaineDto;
import fr.uga.miage.m1.entities.Domaine;

@Mapper(componentModel = "spring")
public interface DomaineMapper {
    DomaineDto toDto(Domaine domaine);
    Domaine toEntity(String nomDomaine);
}
