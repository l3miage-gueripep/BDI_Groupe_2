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

import fr.uga.miage.m1.dto.CommuneDto;
import fr.uga.miage.m1.entities.Commune;
import fr.uga.miage.m1.mapper.CommuneMapper;
import fr.uga.miage.m1.repos.CommuneRepository;
import fr.uga.miage.m1.services.CommuneService;

@ExtendWith(MockitoExtension.class)
class CommuneServiceTest {

    @InjectMocks
    CommuneService service;

    @Mock
    CommuneRepository repo;

    @Mock
    CommuneMapper mapper;


    @Test
    void testGetAll() {
        CommuneDto dto = new CommuneDto();
        Commune entity = new Commune();
        when(repo.findAll()).thenReturn(Arrays.asList(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        List<CommuneDto> result = service.getAll();

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(repo).findAll();
        verify(mapper).toDto(entity);
    }

    @Test
    void testGetAllByNomCommune() {
        String nomCommune = "Test";
        CommuneDto dto = new CommuneDto();
        Commune entity = new Commune();
        when(repo.findByNomCommuneContainingIgnoreCase(nomCommune)).thenReturn(Arrays.asList(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        List<CommuneDto> result = service.getAllByNomCommune(nomCommune);

        assertEquals(1, result.size());
        assertEquals(dto, result.get(0));
        verify(repo).findByNomCommuneContainingIgnoreCase(nomCommune);
        verify(mapper).toDto(entity);
    }
}