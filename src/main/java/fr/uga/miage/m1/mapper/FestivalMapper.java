package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.entities.Festival;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SousDomaineMapper.class)
public interface FestivalMapper {
    FestivalDto toDto(Festival festival);

    Festival toEntity(FestivalDto dto);
}
