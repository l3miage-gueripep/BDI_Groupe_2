package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import fr.uga.miage.m1.dto.SousDomaineDto;
import fr.uga.miage.m1.entities.SousDomaine;

@Mapper(componentModel = "spring", uses = DomaineMapper.class)
public interface SousDomaineMapper {
    @Mapping(source = "domaine.nomDomaine", target = "nomDomaine")
    SousDomaineDto toDto(SousDomaine sousDomaine);
    SousDomaine toEntity(SousDomaineDto dto);
}