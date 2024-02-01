package fr.uga.miage.m1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import fr.uga.miage.m1.dto.AdherentDto;
import fr.uga.miage.m1.entities.Adherent;
import fr.uga.miage.m1.mapper.AdherentMapper;
import fr.uga.miage.m1.repos.AdherentRepo;
import fr.uga.miage.m1.services.AdherentService;

@ExtendWith(MockitoExtension.class)
class AdherentServiceTest {

    @InjectMocks
    AdherentService service;

    @Mock
    AdherentRepo repo;

    @Mock
    AdherentMapper mapper;

    @Test
    void testCreate() {
        AdherentDto dto = new AdherentDto();
        Adherent entity = new Adherent();
        when(mapper.toEntity(dto)).thenReturn(entity);
        when(repo.save(any(Adherent.class))).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(dto);

        AdherentDto result = service.create(dto);

        assertEquals(dto, result);
        verify(mapper).toEntity(dto);
        verify(repo).save(entity);
        verify(mapper).toDto(entity);
    }

    @Test
    void testGetAll() {
        AdherentDto dto = new AdherentDto();
        Adherent entity = new Adherent();
        when(repo.findAll()).thenReturn(Arrays.asList(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        List<AdherentDto> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(repo).findAll();
        verify(mapper).toDto(entity);
    }
}