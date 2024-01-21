package fr.uga.miage.m1.mapper;

import org.mapstruct.Mapper;
import fr.uga.miage.m1.entities.Domaine;

@Mapper(componentModel = "spring")
public interface DomaineMapper {
    Domaine toEntity(String nomDomaine);
}
