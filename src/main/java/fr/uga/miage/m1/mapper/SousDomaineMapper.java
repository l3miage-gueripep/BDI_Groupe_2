package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;

import fr.uga.miage.m1.dto.SousDomaineDto;
import fr.uga.miage.m1.entities.SousDomaine;

@Mapper(componentModel = "spring")
public interface SousDomaineMapper {
    SousDomaineDto toDto(SousDomaine sousDomaine);
    SousDomaine toEntity(SousDomaineDto dto);
}