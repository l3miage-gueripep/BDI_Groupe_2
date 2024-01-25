package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.dto.FestivalDto;
import fr.uga.miage.m1.entities.Festival;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FestivalMapper {
    FestivalDto toDto(Festival festival);
    Festival toEntity(FestivalDto dto);
}